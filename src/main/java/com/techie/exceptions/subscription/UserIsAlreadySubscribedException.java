package com.techie.exceptions.subscription;

public class UserIsAlreadySubscribedException extends RuntimeException {
    public UserIsAlreadySubscribedException(String message) {
        super(message);
    }
}