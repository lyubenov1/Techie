package com.techie.exceptions.user;

public class UserAlreadyBlacklistedException extends RuntimeException {
    public UserAlreadyBlacklistedException(String email) {
        super("User with email: " + email + " is already blacklisted");
    }
}
