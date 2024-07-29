package com.techie.exceptions.product;

public class MissingProductDataException extends RuntimeException {
    public MissingProductDataException(String message) {
        super(message);
    }
}