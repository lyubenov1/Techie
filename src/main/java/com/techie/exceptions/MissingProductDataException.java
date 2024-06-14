package com.techie.exceptions;

public class MissingProductDataException extends RuntimeException {
    public MissingProductDataException(String message) {
        super(message);
    }
}