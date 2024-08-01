package com.techie.exceptions.email;

public class EmailNotificationException extends RuntimeException {
    public EmailNotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
