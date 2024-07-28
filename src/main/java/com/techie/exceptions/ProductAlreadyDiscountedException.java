package com.techie.exceptions;

public class ProductAlreadyDiscountedException extends RuntimeException {
    public ProductAlreadyDiscountedException(Long productId) {
        super("Product " + productId + " is already discounted");
    }
}
