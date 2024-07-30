package com.techie.interceptors;

import com.techie.domain.entities.*;
import com.techie.service.*;
import jakarta.servlet.http.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.lang.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.*;

@Component
public class UserBlacklistInterceptor implements HandlerInterceptor {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserBlacklistInterceptor.class);

    @Autowired
    public UserBlacklistInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {
        String path = request.getRequestURI();
        if (path.equals("/blacklisted")) {
            return true; // Allow this path to proceed without checking. This avoids too many redirects error
        }

        String username = getUsernameFromRequest();
        if (username != null) {
            UserEntity user = userService.findByUsernameNoFetches(username);
            if (user != null) {
                boolean isBlacklisted = userService.isBlacklisted(user.getId());
                if (isBlacklisted) {
                    log.info("Blocked access attempt by blacklisted user: {}", username);
                    response.sendRedirect("/blacklisted");
                    return false;
                }
            }
        }
        return true;
    }

    private String getUsernameFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() &&
                authentication.getPrincipal() instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        }
        return null;
    }
}
