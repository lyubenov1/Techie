package com.techie.exceptions.user;

public class UserIsAlreadySubscribedException extends RuntimeException {
    public UserIsAlreadySubscribedException(String message) {
        super(message);
    }
}