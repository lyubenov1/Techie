package com.techie.config;

import org.springframework.boot.test.context.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.web.*;
import org.springframework.web.servlet.*;

@TestConfiguration
@EnableWebSecurity
public class TestConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public ViewResolver viewResolver() {
        // Return null to prevent Thymeleaf from resolving any templates
        return (viewName, locale) -> null;
    }
}
