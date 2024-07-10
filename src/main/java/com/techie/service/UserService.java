package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.*;
import com.techie.repository.*;
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
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService,
                       RoleRepository roleRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void registerUser(RegisterModel registrationDTO, Consumer<Authentication> successfulLoginProcessor) {

        // Create UserEntity
        UserEntity userEntity = UserEntity.builder()
                .username(registrationDTO.getUsername())
                .firstName(registrationDTO.getFirstName())
                .lastName(registrationDTO.getLastName())
                .email(registrationDTO.getEmail())
                .password(passwordEncoder.encode(registrationDTO.getPassword()))
                .build();

        // Set roles
        RoleEntity userRole = roleRepository.findRoleEntityByRole(UserRoleEnum.USER).orElseThrow();
        userEntity.setRoles(List.of(userRole));

        // Save UserEntity
        userRepository.save(userEntity);

        // Create Address
        Address address = Address.builder()
                .addressLine1(registrationDTO.getAddressLine1())
                .addressLine2(registrationDTO.getAddressLine2())
                .city(registrationDTO.getCity())
                .country(registrationDTO.getCountry())
                .zipcode(registrationDTO.getZipCode())
                .user(userEntity)
                .build();

        // Save Address
        addressRepository.save(address);

        // Load UserDetails
        UserDetails userDetails = userDetailsService.loadUserByUsername(registrationDTO.getEmail());

        // Create Authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        // Process successful login
        successfulLoginProcessor.accept(authentication);
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    @Transactional
    public void addRoleToUser(String email, UserRoleEnum role) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
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
}