package com.techie.exceptions.wishlist;

public class InvalidWishlistNameException extends RuntimeException {
    public InvalidWishlistNameException(String message) {
        super(message);
    }
}