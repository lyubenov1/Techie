package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.models.*;
import com.techie.repository.*;
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
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;
    private final WishlistService wishlistService;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;
    private final MailService mailService;

    @Autowired
    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           AddressRepository addressRepository, WishlistService wishlistService,
                           UserDetailsService userDetailsService, RoleRepository roleRepository,
                           MailService mailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
        this.wishlistService = wishlistService;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.mailService = mailService;
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

        mailService.sendRegistrationEmail(userEntity);
    }

    UserEntity createUserEntity(RegisterModel registrationModel) {
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

    Address createAddress(RegisterModel registrationDTO, UserEntity userEntity) {
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
}
