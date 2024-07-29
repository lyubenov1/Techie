package com.techie.exceptions.address;

public class AddressExistsException extends RuntimeException {
    public AddressExistsException(String addressName) {
        super("Address with name '" + addressName + "' already exists");
    }
}
