package com.techie.interceptors;

import com.techie.service.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.lang.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.*;

@Component
public class BreadcrumbInterceptor implements HandlerInterceptor {

    private final BreadcrumbService breadcrumbService;

    @Autowired
    public BreadcrumbInterceptor(BreadcrumbService breadcrumbService) {
        this.breadcrumbService = breadcrumbService;
    }

    @Override
    public void postHandle(@Nullable HttpServletRequest request,
                           @Nullable HttpServletResponse response,
                           @Nullable Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("breadcrumb", breadcrumbService.getBreadcrumbs(request));
        }
    }
}