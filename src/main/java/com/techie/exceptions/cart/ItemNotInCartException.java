package com.techie.exceptions.cart;

public class ItemNotInCartException extends RuntimeException {
    public ItemNotInCartException(String message) {
        super(message);
    }
}
