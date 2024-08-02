package com.techie.filters;

import com.techie.service.*;
import io.github.bucket4j.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.lang.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.filter.*;

import java.io.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Filter for implementing rate limiting on unsuccessful login attempts.
 * This filter tracks failed login attempts for each email address and
 * limits the number of attempts within a specified time frame.
 */
@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private final Map<String, TrackedBucket> emailBuckets = new ConcurrentHashMap<>();
    private final MailService mailService;

    /**
     * Constructs a RateLimitFilter with the specified MailService.
     *
     * @param mailService The MailService used to send warning emails.
     */
    @Autowired
    public RateLimitFilter(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * Performs the actual filtering for each request.
     * This method is called by the servlet container for every request.
     *
     * @param request The HTTP servlet request.
     * @param response The HTTP servlet response.
     * @param filterChain The filter chain for invoking the next filter.
     * @throws jakarta.servlet.ServletException If a servlet exception occurs.
     * @throws java.io.IOException If an I/O exception occurs.
     */
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String email = getEmailFromRequest(request);

        if (email != null && !email.isEmpty()) {
            if (isFailedLoginAttempt(request)) {
                boolean emailAllowed = checkRateLimit(email);
                if (!emailAllowed) {
                    mailService.sendLoginAttemptWarning(email);
                    response.sendRedirect("/too-many-requests");
                    return; // Don't proceed with the filter chain
                }
            }
        }

        // If we haven't exceeded the rate limit, or it's not a failed login attempt, proceed with the filter chain
        filterChain.doFilter(request, response);
    }

    /**
     * Checks if the rate limit for a given email has been exceeded.
     *
     * @param email The email address to check.
     * @return true if the rate limit has not been exceeded, false otherwise.
     */
    private boolean checkRateLimit(String email) {
        TrackedBucket trackedBucket = emailBuckets.computeIfAbsent(email, k -> new TrackedBucket(createNewBucket()));
        return trackedBucket.tryConsumeAndReturnRemaining(1).isConsumed();
    }

    /**
     * Determines if the current request represents a failed login attempt.
     *
     * @return true if it's a failed login attempt, false otherwise.
     */
    private boolean isFailedLoginAttempt(HttpServletRequest request) {
        Boolean loginFailed = (Boolean) request.getSession().getAttribute("failedLoginAttempt");
        if (loginFailed != null && loginFailed) {
            request.getSession().removeAttribute("failedLoginAttempt");
            return true;
        }
        return false;
    }

    /**
     * Retrieves the email address from the request parameters.
     *
     * @param request The HTTP servlet request.
     * @return The email address, or null if not present.
     */
    private String getEmailFromRequest(HttpServletRequest request) {
        return request.getParameter("email");
    }

    /**
     * Creates a new rate limiting bucket with specified constraints.
     *
     * @return A new Bucket instance.
     */
    private Bucket createNewBucket() {
        long overdraft = 4; // Allow 4 extra requests initially (burst capacity)
        Refill refill = Refill.intervally(4, Duration.ofHours(24)); // Refill 4 tokens every 24 hours
        Bandwidth limit = Bandwidth.classic(overdraft, refill);
        return Bucket.builder().addLimit(limit).build();
    }

    /**
     * Scheduled task to clean up old entries from the emailBuckets map.
     * This helps prevent memory leaks by removing buckets for email addresses that are no longer actively trying to log in.
     */
    @Scheduled(fixedRate = 3600000) // Run every hour
    public void cleanupBuckets() {
        long now = System.currentTimeMillis();
        emailBuckets.entrySet().removeIf(entry ->
                now - entry.getValue().getLastRefillTime() > Duration.ofHours(24).toMillis()
        );
    }
}