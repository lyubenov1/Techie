package com.techie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final BreadcrumbInterceptor breadcrumbInterceptor;

    @Autowired
    public WebMvcConfig(BreadcrumbInterceptor breadcrumbInterceptor) {
        this.breadcrumbInterceptor = breadcrumbInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(breadcrumbInterceptor);
    }
}