package com.techie.exceptions;

public class UserNotInBlacklistException extends RuntimeException {
    public UserNotInBlacklistException(Long id) {
        super("User with id " + id + " is not found in the blacklist");
    }
}
