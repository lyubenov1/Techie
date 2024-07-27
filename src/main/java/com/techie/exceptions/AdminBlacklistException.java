package com.techie.exceptions;

public class AdminBlacklistException extends RuntimeException {
    public AdminBlacklistException(String message) {
        super(message);
    }
}
