package com.techie.config;

import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.security.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.authentication.rememberme.*;
import org.springframework.security.web.context.*;

import javax.sql.*;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {

    private final ApplicationUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    @Autowired
    public SecurityConfiguration(ApplicationUserDetailsService userDetailsService,
                                 PasswordEncoder passwordEncoder, DataSource dataSource) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           SecurityContextRepository securityContextRepository) throws Exception {
        http
                // Define authorization rules
                .authorizeHttpRequests(authorize -> authorize
                        // Allow access to all static files (images, CSS, js)
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()

                        // Public pages
                        .requestMatchers("/", "/products/**", "/terms-of-use", "/unauthorized", "/blacklisted",
                                "/privacy-policy", "/about-us", "/example/test", "/email/**").permitAll()

                        // Authentication pages
                        .requestMatchers("/login/**", "/register", "/login-error").anonymous()

                        // Public API endpoints
                        .requestMatchers("/api/categories", "/api/products/**", "/api/settings/subscription/change/email",
                                "/api/search", "/api/reviews/get/**").permitAll()

                        // Admin and Moderator specific endpoints
                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/moderator", "/api/admin/promotion/**",
                                "/api/admin/discount/**").hasAnyAuthority("ROLE_MODERATOR", "ROLE_ADMIN")
                        .requestMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")

                        // Authenticated user endpoints
                        .requestMatchers("/users/**", "/api/reviews/vote/**", "/api/settings/**").authenticated()

                        // Any other request
                        .anyRequest().authenticated()
                )
                // configure login with HTML form
                .formLogin(form -> form
                        .loginPage("/login")
                        // the names of the username, password input fields in the custom login form
                        .usernameParameter("email")
                        .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                        .successHandler((request, response, authentication) -> {
                            // Using successHandler to set a login message in the session and control the post-login redirect.
                            request.getSession().setAttribute("loginMessage", "✓ You have successfully logged in!");
                            response.sendRedirect("/users/profile");
                        })
                        // Commented, because it doesn't work with successHandler. Still a valid option.
                        // .defaultSuccessUrl("/users/profile", true) // use true argument if you always want to go there, otherwise go to previous page
                        .failureForwardUrl("/login-error")
                        .permitAll()
                )
                // configure logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                .securityContext(securityContext -> securityContext
                        .securityContextRepository(securityContextRepository)
                )
                // Exception handling configuration
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(customAccessDeniedHandler())
                )
                .authenticationProvider(authenticationProvider()
                )
                // configure "Remember Me" functionality
                .rememberMe(rememberMe -> rememberMe
                        .rememberMeParameter("remember-me")
                        .rememberMeCookieName("remember-me-cookie")
                        .tokenValiditySeconds(2592000) // 30 days
                        .tokenRepository(persistentTokenRepository())
                        .userDetailsService(userDetailsService)
                );

        return http.build();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }
}