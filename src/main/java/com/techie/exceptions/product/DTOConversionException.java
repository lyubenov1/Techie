package com.techie.exceptions.product;

public class DTOConversionException extends RuntimeException {
    public DTOConversionException(String message, Throwable cause) { // Include cause
        super(message, cause);
    }
}
