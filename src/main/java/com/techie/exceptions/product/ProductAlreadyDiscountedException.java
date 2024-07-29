package com.techie.exceptions.product;

public class ProductAlreadyDiscountedException extends RuntimeException {
    public ProductAlreadyDiscountedException(Long productId) {
        super("Product " + productId + " is already discounted");
    }
}
