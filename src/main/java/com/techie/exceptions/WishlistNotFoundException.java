package com.techie.exceptions;

public class WishlistNotFoundException extends ObjectNotFoundException {
    public WishlistNotFoundException(Long wishlistId) {
        super("Wishlist not found with ID: " + wishlistId);
    }
}