package com.techie.exceptions;

public class ProductNotFoundException extends ObjectNotFoundException {
    public ProductNotFoundException(Long productId) {
        super("Product not found with ID: " + productId);
    }
}