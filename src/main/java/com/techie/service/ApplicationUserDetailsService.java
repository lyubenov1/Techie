package com.techie.service;

import com.techie.domain.entities.RoleEntity;
import com.techie.domain.entities.UserEntity;
import com.techie.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return
                userRepository.
                        findByEmail(username).
                        map(this::map).
                        orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                extractAuthorities(userEntity)
        );
    }

    private List<GrantedAuthority> extractAuthorities(UserEntity user) {
        return user.
                getRoles().
                stream().
                map(this::mapRole).
                toList();
    }

    private GrantedAuthority mapRole(RoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
    }

}
