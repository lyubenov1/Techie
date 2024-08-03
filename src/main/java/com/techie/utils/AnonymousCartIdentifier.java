package com.techie.utils;

import jakarta.servlet.http.*;

import java.util.*;

/**
 * The {@code AnonymousCartIdentifier} class provides a method to get or create
 * a unique identifier for an anonymous shopping cart session. This identifier
 * is stored in the user's HTTP session.
 */
public class AnonymousCartIdentifier {
    /**
     * The session attribute key used to store the anonymous cart identifier.
     */
    private static final String ANONYMOUS_CART_ID = "anonymousCartId";

    /**
     * Retrieves the anonymous cart identifier from the session. If it doesn't exist,
     * a new unique identifier is generated, stored in the session, and returned.
     */
    public static String getOrCreateIdentifier(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String cartId = (String) session.getAttribute(ANONYMOUS_CART_ID);
        if (cartId == null) {
            cartId = UUID.randomUUID().toString();
            session.setAttribute(ANONYMOUS_CART_ID, cartId);
        }
        return cartId;
    }
}
