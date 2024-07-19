package com.techie.exceptions;

public class DuplicateWishlistException extends RuntimeException {
    public DuplicateWishlistException(String wishlistName) {
        super("You already have a wishlist named \"" + wishlistName + "\"");
    }
}