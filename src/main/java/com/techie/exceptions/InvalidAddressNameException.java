package com.techie.exceptions;

public class InvalidAddressNameException extends RuntimeException {
    public InvalidAddressNameException() {
        super("Address name exceeds the maximum length of 25 characters");
    }
}
