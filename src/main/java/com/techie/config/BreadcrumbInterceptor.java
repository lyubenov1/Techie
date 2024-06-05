package com.techie.config;

import com.techie.service.BreadcrumbService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class BreadcrumbInterceptor implements HandlerInterceptor {

    private final BreadcrumbService breadcrumbService;

    @Autowired
    public BreadcrumbInterceptor(BreadcrumbService breadcrumbService) {
        this.breadcrumbService = breadcrumbService;
    }

    @Override
    public void postHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("breadcrumb", breadcrumbService.getBreadcrumbs(request));
        }
    }
}