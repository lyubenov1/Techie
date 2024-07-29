package com.techie.exceptions.product;

import com.techie.exceptions.*;

public class ProductNotFoundException extends ObjectNotFoundException {
    public ProductNotFoundException(String productName) {
        super("Product with name \"" + productName + "\" not found");
    }

    public ProductNotFoundException(Long productId) {
        super("Product with ID \"" + productId + "\" not found");
    }
}