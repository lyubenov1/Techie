package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.DTOs.*;
import com.techie.domain.model.*;
import com.techie.repository.*;
import com.techie.utils.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
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
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService, RoleRepository roleRepository,
                       AddressRepository addressRepository, WishlistService wishlistService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.wishlistService = wishlistService;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByEmailWithWishlists(username)
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
                .password(passwordEncoder.encode(registrationModel.getPassword()))
                .wishlists(new LinkedHashSet<>())
                .build();

        RoleEntity userRole = roleRepository.findRoleEntityByRole(UserRoleEnum.USER).orElseThrow();
        userEntity.setRoles(List.of(userRole));

        return userEntity;
    }

    private Address createAddress(RegisterModel registrationDTO, UserEntity userEntity) {
        return Address.builder()
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
    public void addRoleToUser(String email, UserRoleEnum role) {
        Optional<UserEntity> optionalUser = userRepository.findByEmailWithRoles(email);
        Optional<RoleEntity> optionalRole = roleRepository.findRoleEntityByRole(role);

        if (optionalUser.isPresent() && optionalRole.isPresent()) {
            UserEntity user = optionalUser.get();
            RoleEntity roleEntity = optionalRole.get();

            if (user.getRoles().contains(roleEntity)) {
                logger.info("User {} already has role: {}", email, role);
            } else {
                user.getRoles().add(roleEntity);
                userRepository.save(user);
                logger.info("Added role {} to user: {}", role, email);
            }
        } else {
            if (optionalUser.isEmpty()) {
                logger.warn("User with email {} not found.", email);
            }
            if (optionalRole.isEmpty()) {
                logger.warn("Role {} not found.", role);
            }
        }
    }

    public UserDisplayView convertToView(UserEntity user) {
        UserDisplayView view = UserConversionUtils.convertToView(user);
        List<WishlistDTO> wishlistDTOs = user.getWishlists().stream()
                .map(wishlistService::convertToDto)
                .toList();
        view.setWishlists(wishlistDTOs);
        return view;
    }
}