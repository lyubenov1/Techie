package com.techie.aspect;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;

/**
 * Aspect for logging user roles when accessing specific methods.
 */
@Aspect
@Component
public class LoggingAspect {

    // Logger for logging information
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Pointcut expression that matches the execution of the `home` method
     * in the `HomeController` class.
     * <p>
     * This specifies that the aspect should apply to the `home` method
     * that returns a `String` and is defined in the `HomeController` class
     * located in the `com.techie.web` package.
     * </p>
     *
     * @param joinPoint The join point representing the method execution
     */
    @AfterReturning("execution(String com.techie.web.HomeController.home())")
    public void logUserRoles(JoinPoint joinPoint) {
        // Retrieve the current Authentication object from the security context
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            // Log the roles of the currently authenticated user
            logger.info("User roles: {}", auth.getAuthorities());

            // Log the signature of the method that was accessed
            logger.info("Accessed method: {}", joinPoint.getSignature());
        }
    }
}
