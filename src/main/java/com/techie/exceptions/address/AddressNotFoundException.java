package com.techie.exceptions.address;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(Long addressId) {
        super("Address with id '" + addressId + "' not found");
    }
}
