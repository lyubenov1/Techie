package com.techie.exceptions;

public class ProductNotFoundException extends ObjectNotFoundException {
    public ProductNotFoundException(String productName) {
        super("Category with name \"" + productName + "\" not found");
    }
}