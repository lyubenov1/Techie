package com.techie.exceptions.subscription;

public class EmailNotificationException extends RuntimeException {
    public EmailNotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
