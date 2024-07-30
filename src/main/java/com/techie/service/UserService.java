package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.*;
import com.techie.exceptions.role.*;
import com.techie.exceptions.user.*;
import com.techie.repository.*;
import com.techie.utils.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final BlacklistRepository blacklistRepository;
    private final WishlistService wishlistService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService, RoleRepository roleRepository,
                       AddressRepository addressRepository, WishlistService wishlistService,
                       BlacklistRepository blacklistRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.wishlistService = wishlistService;
        this.blacklistRepository = blacklistRepository;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByEmailFetchRolesAndWishlists(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    public UserEntity findByUsernameWithRoles(String username) {
        return userRepository.findByEmailFetchRoles(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    public UserEntity findByUsernameNoFetches(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    @Transactional
    public void registerUser(RegisterModel registerModel, Consumer<Authentication> successfulLoginProcessor) {
        UserEntity userEntity = createUserEntity(registerModel);
        userRepository.save(userEntity);

        Address address = createAddress(registerModel, userEntity);
        addressRepository.save(address);

        // Create default wishlist. Relationship with user is established before entity persisting.
        wishlistService.createWishlist(userEntity, "Main wishlist");

        Authentication authentication = authenticateUser(registerModel.getEmail());
        successfulLoginProcessor.accept(authentication);
    }

    private UserEntity createUserEntity(RegisterModel registrationModel) {
        UserEntity userEntity = UserEntity.builder()
                .username(registrationModel.getUsername())
                .firstName(registrationModel.getFirstName())
                .lastName(registrationModel.getLastName())
                .email(registrationModel.getEmail())
                .profileImageUrl("/images/profile_default_photo.png")
                .password(passwordEncoder.encode(registrationModel.getPassword()))
                .wishlists(new LinkedHashSet<>())
                .build();

        RoleEntity userRole = roleRepository.findRoleEntityByRole(UserRoleEnum.USER).orElseThrow();
        userEntity.setRoles(List.of(userRole));

        return userEntity;
    }

    private Address createAddress(RegisterModel registrationDTO, UserEntity userEntity) {
        String defaultAddressName = "Address 1";

        return Address.builder()
                .name(defaultAddressName)
                .addressLine1(registrationDTO.getAddressLine1())
                .addressLine2(registrationDTO.getAddressLine2())
                .city(registrationDTO.getCity())
                .country(registrationDTO.getCountry())
                .zipcode(registrationDTO.getZipCode())
                .user(userEntity)
                .build();
    }

    private Authentication authenticateUser(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        return new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
    }

    @Transactional
    public void addRoleToUser(String email, UserRoleEnum role)
                               throws UserAlreadyHasRoleException {
        Optional<UserEntity> optionalUser = userRepository.findByEmailFetchRoles(email);
        Optional<RoleEntity> optionalRole = roleRepository.findRoleEntityByRole(role);

        if (optionalUser.isPresent() && optionalRole.isPresent()) {
            UserEntity user = optionalUser.get();
            RoleEntity roleEntity = optionalRole.get();

            if (user.getRoles().contains(roleEntity)) {
                throw new UserAlreadyHasRoleException(roleEntity.toString());
            } else {
                user.getRoles().add(roleEntity);
                userRepository.save(user);
                logger.info("Added role {} to user: {}", role, email);
            }
        } else {
            if (optionalUser.isEmpty()) {
                logger.info("User with email {} not found!", email);
            }
        }
    }

    public UserDisplayView convertToView(UserEntity user) {
        return UserConversionUtils.convertToView(user);
    }

    public List<UserDisplayView> getUsers(String query) {
        List<UserEntity> users;

        if (query == null || query.isEmpty()) {
            users = userRepository.findAllUsersNotBlacklisted();
        } else {
            users = userRepository.findByEmailContainingNotBlacklisted(query);
        }

        return users.stream()
                .map(this::convertToView)
                .toList();
    }

    @CachePut(value = "userBlacklist", key = "#userDisplayView.id")
    @Transactional
    public void blacklistUser(UserDisplayView userDisplayView)
                               throws UsernameNotFoundException, UserAlreadyBlacklistedException, AdminModeratorBlacklistException {
        UserEntity user = findByUsernameNoFetches(userDisplayView.getEmail());

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
                    UserDisplayView userView = convertToView(user);

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
        logger.info("Attempting to remove user {} from blacklist", userId);
        Blacklist blacklist = blacklistRepository.findByUserId(userId)
                .orElseThrow(() -> {
                    logger.warn("User {} not found in blacklist", userId);
                    return new UserNotInBlacklistException(userId);
                });
        blacklistRepository.delete(blacklist);
        logger.info("User {} successfully removed from blacklist", userId);
    }

    @Transactional
    public void makeModerator(UserDisplayView userDisplayView) throws UserAlreadyHasRoleException {

        if ("Admin".equals(userDisplayView.getRole())) {
            throw new UserAlreadyHasRoleException("ADMIN");
        }

        addRoleToUser(userDisplayView.getEmail(), UserRoleEnum.MODERATOR);
    }

    public Page<UserDisplayView> getModerators(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<UserEntity> moderatorsPage = userRepository.findAllModerators(pageable);
            return moderatorsPage.map(this::convertToView);
        } catch (Exception e) {
            logger.error("Error in getModerators: ", e);
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
            userRepository.save(user);
        } else {
            logger.info("User {} is not a moderator, no action taken", userId);
        }
    }

    @Cacheable(value = "userBlacklist", key = "#userId")
    public boolean isBlacklisted(Long userId) {
        logger.debug("Checking if user {} is blacklisted", userId);
        boolean blacklisted = blacklistRepository.findByUserId(userId).isPresent();
        logger.info("User {} is {}blacklisted", userId, blacklisted ? "" : "not ");
        return blacklisted;
    }

    public void updateProfileImage(Long userId, String newProfileImageUrl) {  // TODO
        UserEntity user = userRepository.findById(userId).orElseThrow();
        user.setProfileImageUrl(newProfileImageUrl);
        userRepository.save(user);
    }

}