package com.techie.exceptions;

public class DuplicateWishlistException extends RuntimeException {
    public DuplicateWishlistException(String message) {
        super(message);
    }
}