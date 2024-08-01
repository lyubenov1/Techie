package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.*;
import com.techie.exceptions.user.*;
import com.techie.repository.*;
import com.techie.utils.*;
import jakarta.servlet.http.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.authentication.logout.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.function.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final WishlistService wishlistService;
    private final TokenService tokenService;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService, RoleRepository roleRepository,
                       AddressRepository addressRepository, WishlistService wishlistService,
                       TokenService tokenService, HttpServletRequest request, HttpServletResponse response) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.wishlistService = wishlistService;
        this.tokenService = tokenService;
        this.request = request;
        this.response = response;
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

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
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

    public void updateProfileImage(UserEntity user, String imageUrl, String publicId) {
        user.setProfileImageUrl(imageUrl);
        user.setPublicId(publicId);
        userRepository.save(user);
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Transactional
    public void confirmDelete(String token) {
        String email = tokenService.getEmailByToken(token);
        if (email == null) {
            throw new IllegalArgumentException("Invalid or expired token");
        }

        try {
            // Proceed with user deletion
            userRepository.deleteByEmail(email);
            tokenService.removeToken(token);

            // Programmatic logout
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
                logoutHandler.logout(request, response, authentication);
            }

            logger.info("User with email {} deleted and logged out.", email);
        } catch (Exception e) {
            logger.error("Error during user deletion and logout: ", e);
            throw new RuntimeException("An error occurred while processing the deletion.");
        }
    }

    public List<UserEntity> getSubscribedUsers() {
        return userRepository.findSubscribedUsers();
    }
}