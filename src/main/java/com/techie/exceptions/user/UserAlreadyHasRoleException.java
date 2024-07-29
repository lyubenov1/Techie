package com.techie.exceptions.user;

public class UserAlreadyHasRoleException extends RuntimeException {
    public UserAlreadyHasRoleException(String role) {
        super("User already has role: " + role);
    }
}
