package com.techie.exceptions;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(Long addressId) {
        super("Address with id '" + addressId + "' not found");
    }
}
