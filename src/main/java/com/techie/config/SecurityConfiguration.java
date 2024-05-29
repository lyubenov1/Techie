package com.techie.config;

import com.techie.domain.enums.UserRoleEnum;
import com.techie.repository.UserRepository;
import com.techie.service.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${rememberMeKey}")
    private String rememberMeKey;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           SecurityContextRepository securityContextRepository) throws Exception {
        http
                // defines which pages will be authorized
                .authorizeHttpRequests(authorize -> authorize
                        // allow access to all static files (images, CSS, js)
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // the URLs below are available for all users - logged in and anonymous
                        .requestMatchers("/", "/users/login", "/users/register", "/users/login-error", "/products/**").permitAll()
                        .requestMatchers("/admin/**").hasRole(UserRoleEnum.ADMIN.name())
                        .requestMatchers("/profile/**").authenticated()
                        .anyRequest().authenticated()
                )
                // configure login with HTML form
                .formLogin(form -> form
                        .loginPage("/users/login")
                        // the names of the username, password input fields in the custom login form
                        .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                        .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                        // where do we go after login
                        .defaultSuccessUrl("/", true) // use true argument if you always want to go there, otherwise go to previous page
                        .failureForwardUrl("/users/login-error")
                )
                // configure logout
                .logout(logout -> logout
                        .logoutUrl("/users/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                )
                .securityContext(securityContext -> securityContext
                        .securityContextRepository(securityContextRepository)
                )
                // configure "Remember Me" functionality
                .rememberMe(rememberMe -> rememberMe
                        .rememberMeParameter("remember-me")
                        .key(rememberMeKey)
                        .rememberMeCookieName("remember-me-cookie")
                        .tokenValiditySeconds(100000)
                )
                // Exception handling configuration
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(customAccessDeniedHandler())
                )
                // Configure CSRF protection
                .csrf(csrf -> csrf
                        .csrfTokenRepository(csrfTokenRepository())
                );


        return http.build();
    }


    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailsService(userRepository);
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }

}
