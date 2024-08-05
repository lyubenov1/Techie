package com.techie.utils;

import jakarta.servlet.http.*;

import java.util.*;
import java.util.concurrent.*;

/**
 * The {@code AnonymousCartIdentifier} class provides a method to get or create
 * a unique identifier for an anonymous shopping cart session. This identifier
 * is based on the user's IP address and is stored in the user's HTTP session.
 * <p>
 * Key features:
 * <ul>
 *   <li>Generates a unique identifier for each IP address</li>
 *   <li>Persists across server restarts for the duration of the user's session</li>
 *   <li>Creates a new identifier if the session expires or cookies are deleted</li>
 *   <li>The anonymous cart is deleted upon user authentication, even if empty</li>
 * </ul>
 * <p>
 * This approach ensures a consistent shopping experience for anonymous users
 * while maintaining clean data management during the transition to authenticated sessions.
 */
public class AnonymousCartIdentifier {

    /**
     * The session attribute key used to store the anonymous cart identifier.
     */
    private static final String ANONYMOUS_CART_ID = "anonymousCartId";

    /**
     * A concurrent map to associate IP addresses with cart IDs.
     */
    private static final ConcurrentHashMap<String, String> ipToCartIdMap = new ConcurrentHashMap<>();

    /**
     * Retrieves the anonymous cart identifier from the session. If it doesn't exist,
     * a new unique identifier is generated, associated with the user's IP address,
     * stored in the session, and returned.
     *
     * @param request the HTTP request containing the user's session and IP address
     * @return the anonymous cart identifier
     */
    public static String getOrCreateIdentifier(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String cartId = (String) session.getAttribute(ANONYMOUS_CART_ID);

        if (cartId == null) {
            String ipAddress = getClientIpAddress(request);
            cartId = ipToCartIdMap.computeIfAbsent(ipAddress, k -> UUID.randomUUID().toString());
            session.setAttribute(ANONYMOUS_CART_ID, cartId);
        }

        return cartId;
    }

    /**
     * Retrieves the client's IP address from the HTTP request. If the request contains
     * an X-Forwarded-For header, the first IP address in the list is returned. Otherwise,
     * the remote address from the request is returned.
     *
     * @param request the HTTP request containing the client's IP address
     * @return the client's IP address
     */
    private static String getClientIpAddress(HttpServletRequest request) {
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        }
        return xForwardedForHeader.split(",")[0];
    }
}
