package com.techie.exceptions;

public class UserAlreadyHasRoleException extends RuntimeException {
    public UserAlreadyHasRoleException(String role) {
        super("User already has role: " + role);
    }
}
