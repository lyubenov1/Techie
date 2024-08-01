package com.techie.exceptions.settings;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("Password is incorrect");
    }
}
