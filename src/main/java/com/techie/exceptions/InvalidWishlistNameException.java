package com.techie.exceptions;

public class InvalidWishlistNameException extends RuntimeException {
    public InvalidWishlistNameException(String message) {
        super(message);
    }
}