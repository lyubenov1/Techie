package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.models.*;
import com.techie.events.*;
import com.techie.exceptions.product.*;
import com.techie.exceptions.role.*;
import com.techie.exceptions.user.*;
import com.techie.repository.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.context.*;
import org.springframework.data.domain.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.math.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

@Service
public class AdminService {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final UserRepository userRepository;
    private final UserService userService;
    private final BlacklistRepository blacklistRepository;
    private final RoleRepository roleRepository;
    private final MailService mailService;
    private final ApplicationEventPublisher eventPublisher;
    private static final Logger log = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    public AdminService(ProductRepository productRepository, ProductService productService,
                        BlacklistRepository blacklistRepository, UserRepository userRepository,
                        UserService userService, RoleRepository roleRepository,
                        MailService mailService, ApplicationEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.blacklistRepository = blacklistRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.mailService = mailService;
        this.eventPublisher = eventPublisher;
    }

    public List<ProductAdminView> getProductsAdmin(String query) {
        List<Product> products;

        if (query == null || query.isEmpty()) {
            products = productRepository.findAllForAdminView();
        } else {
            products = productRepository.findByNameForAdminView(query);
        }

        return products.stream()
                .map(productService::convertToAdminView)
                .toList();
    }

    public Page<ProductAdminView> getDiscountedProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Product> products = productRepository.findAllDiscountedProducts(pageable);
        long total = productRepository.countDiscountedProducts();

        List<ProductAdminView> productViews = products.stream()
                .map(productService::convertToAdminView)
                .collect(Collectors.toList());

        return new PageImpl<>(productViews, pageable, total);
    }

    @Transactional
    public void discountProduct(ProductAdminView productAdminView)
            throws ProductNotFoundException, ProductAlreadyDiscountedException {

        Product product = productRepository.findById(productAdminView.getId())
                .orElseThrow(() -> new ProductNotFoundException(productAdminView.getId()));

        if (product.getDiscount() != null) {
            throw new ProductAlreadyDiscountedException(productAdminView.getId());
        }

        BigDecimal discountedPrice = getDiscountedPrice(productAdminView, product);

        product.setDiscount(productAdminView.getDiscount());
        product.setDiscountedPrice(discountedPrice);

        productRepository.save(product);

        // Notify subscribed users asynchronously
        mailService.sendDiscountNotification(product);

        eventPublisher.publishEvent(new ProductPriceChangeEvent(product.getId()));
    }

    private static BigDecimal getDiscountedPrice(ProductAdminView productAdminView, Product product) {
        BigDecimal discountPercentage = productAdminView.getDiscount();

        if (discountPercentage == null || discountPercentage.compareTo(BigDecimal.ZERO) <= 0 || discountPercentage.compareTo(new BigDecimal("100")) > 0) {
            throw new IllegalArgumentException("Invalid discount percentage. Must be between 0 and 100.");
        }

        // Calculate the discounted price
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        BigDecimal discountFactor = BigDecimal.ONE.subtract(discountPercentage.divide(new BigDecimal("100"), mc));
        BigDecimal discountedPrice = product.getOriginalPrice().multiply(discountFactor, mc);

        // Round to two decimal places for currency
        return discountedPrice.setScale(2, RoundingMode.HALF_UP);
    }

    @Transactional
    public void removeDiscount(Long productId) throws ProductNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

        if (product.getDiscount() == null) {
            throw new IllegalStateException("Product does not have a discount applied.");
        }

        product.setDiscount(null);
        product.setDiscountedPrice(null);
        productRepository.save(product);

        eventPublisher.publishEvent(new ProductPriceChangeEvent(product.getId()));
    }

    public List<UserDisplayView> getUsers(String query) {
        List<UserEntity> users;

        if (query == null || query.isEmpty()) {
            users = userRepository.findAllUsersNotBlacklisted();
        } else {
            users = userRepository.findByEmailContainingNotBlacklisted(query);
        }

        return users.stream()
                .map(userService::convertToView)
                .toList();
    }

    @Transactional
    public void blacklistUser(UserDisplayView userDisplayView)
            throws UsernameNotFoundException, UserAlreadyBlacklistedException, AdminModeratorBlacklistException {
        UserEntity user = userService.findByUsernameNoFetches(userDisplayView.getEmail());

        // Check if the user is already blacklisted
        if (blacklistRepository.findByUserId(user.getId()).isPresent()) {
            throw new UserAlreadyBlacklistedException(user.getEmail());
        }

        // Prevent blacklisting admin
        if ("Admin".equals(userDisplayView.getRole()) || "Moderator".equals(userDisplayView.getRole())) {
            throw new AdminModeratorBlacklistException();
        }

        // Create and save blacklist entity
        Blacklist blacklist = Blacklist.builder()
                .user(user)
                .reason(userDisplayView.getReason())
                .build();
        blacklistRepository.save(blacklist);
    }

    public Page<UserDisplayView> getBlacklistedUsers(int page, int size) {
        // Fetch blacklisted users
        Page<Blacklist> blacklistPage = blacklistRepository.findAllFetchUsers(PageRequest.of(page, size));

        List<UserDisplayView> userDisplayViews = blacklistPage.getContent().stream()
                .map(blacklistEntry -> {
                    UserEntity user = blacklistEntry.getUser();
                    UserDisplayView userView = userService.convertToView(user);

                    // Set blacklist-specific fields
                    userView.setReason(blacklistEntry.getReason());
                    userView.setBlacklistTimestamp(formatDateTime(blacklistEntry.getTimestamp()));

                    return userView;
                })
                .collect(Collectors.toList());

        return new PageImpl<>(userDisplayViews, blacklistPage.getPageable(), blacklistPage.getTotalElements());
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return dateTime.format(formatter);
    }

    @CacheEvict(value = "userBlacklist", key = "#userId")
    @Transactional
    public void removeFromBlacklist(Long userId) {
        log.info("Attempting to remove user {} from blacklist", userId);
        Blacklist blacklist = blacklistRepository.findByUserId(userId)
                .orElseThrow(() -> {
                    log.warn("User {} not found in blacklist", userId);
                    return new UserNotInBlacklistException(userId);
                });
        blacklistRepository.delete(blacklist);
        log.info("User {} successfully removed from blacklist", userId);
    }

    @Transactional
    public void makeModerator(UserDisplayView userDisplayView) throws UserAlreadyHasRoleException {

        if ("Admin".equals(userDisplayView.getRole())) {
            throw new UserAlreadyHasRoleException("ADMIN");
        }

        userService.addRoleToUser(userDisplayView.getEmail(), UserRoleEnum.MODERATOR);
    }

    public Page<UserDisplayView> getModerators(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<UserEntity> moderatorsPage = userRepository.findAllModerators(pageable);
            return moderatorsPage.map(userService::convertToView);
        } catch (Exception e) {
            log.error("Error in getModerators: ", e);
            throw e;
        }
    }

    @Transactional
    public void removeModeratorRoleFromUser(Long userId) throws UserNotFoundException {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        RoleEntity moderatorRole = roleRepository.findRoleEntityByRole(UserRoleEnum.MODERATOR)
                .orElseThrow(() -> new RuntimeException("Moderator role not found"));

        if (user.getRoles().remove(moderatorRole)) {
            userService.saveUser(user);
        } else {
            throw new UserDoesNotHaveRoleException("User with ID " + userId + " does not have moderator role");
        }
    }

    @Cacheable(value = "userBlacklist", key = "#userId")
    public boolean isBlacklisted(Long userId) {
        log.debug("Checking if user {} is blacklisted", userId);
        boolean blacklisted = blacklistRepository.findByUserId(userId).isPresent();
        log.info("User {} is {}blacklisted", userId, blacklisted ? "" : "not ");
        return blacklisted;
    }
}
