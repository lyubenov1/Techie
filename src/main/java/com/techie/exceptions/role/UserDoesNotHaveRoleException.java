package com.techie.exceptions.role;

public class UserDoesNotHaveRoleException extends RuntimeException {
    public UserDoesNotHaveRoleException(String message) {
        super(message);
    }
}
