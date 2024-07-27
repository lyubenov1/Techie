package com.techie.exceptions;

public class AdminBlacklistException extends RuntimeException {
    public AdminBlacklistException() {
        super("Admins cannot be blacklisted!");
    }
}
