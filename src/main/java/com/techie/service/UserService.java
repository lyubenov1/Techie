package com.techie.service;

import com.techie.domain.entities.RoleEntity;
import com.techie.domain.entities.UserEntity;
import com.techie.domain.enums.UserRoleEnum;
import com.techie.domain.model.UserRegisterFormDTO;
import com.techie.repository.RoleRepository;
import com.techie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
    }

    public void registerUser(UserRegisterFormDTO registrationDTO,
                             Consumer<Authentication> successfulLoginProcessor) {

        UserEntity userEntity = UserEntity.builder()
                .username(registrationDTO.getUsername())
                .firstName(registrationDTO.getFirstName())
                .lastName(registrationDTO.getLastName())
                .email(registrationDTO.getEmail())
                .password(passwordEncoder.encode(registrationDTO.getPassword()))
                .build();

        RoleEntity userRole = roleRepository.
                findRoleEntityByRole(UserRoleEnum.USER).orElseThrow();
        userEntity.setRoles(List.of(userRole));

        userRepository.save(userEntity);

        UserDetails userDetails = userDetailsService.loadUserByUsername(registrationDTO.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);
    }

}
