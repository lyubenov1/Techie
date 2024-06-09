package com.techie.config;

import com.techie.interceptors.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final BreadcrumbInterceptor breadcrumbInterceptor;

    @Autowired
    public WebMvcConfig(BreadcrumbInterceptor breadcrumbInterceptor) {
        this.breadcrumbInterceptor = breadcrumbInterceptor;;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(breadcrumbInterceptor);
    }
}