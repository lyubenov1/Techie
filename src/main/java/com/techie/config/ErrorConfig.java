package com.techie.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.handler.*;

import java.util.*;

/**
 * Configuration class for handling custom error pages based on exception types.
 */
@Configuration
public class ErrorConfig {

    /**
     * Defines a SimpleMappingExceptionResolver bean to handle exception mappings.
     *
     * @return HandlerExceptionResolver instance configured to map exceptions to views
     */
    @Bean
    public HandlerExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        // Define properties to map exception classes to specific view names
        Properties properties = new Properties();
        properties.setProperty(NullPointerException.class.getSimpleName(), "error-pages/null-pointer-exception");

        // Set the exception mappings
        resolver.setExceptionMappings(properties);

        return resolver;
    }
}