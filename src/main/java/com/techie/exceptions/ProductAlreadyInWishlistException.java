package com.techie.exceptions;

public class ProductAlreadyInWishlistException extends RuntimeException {
    public ProductAlreadyInWishlistException(String productName, String wishlistName) {
        super("Product with name \"" + productName + "\" already exists in wishlist \"" + wishlistName + "\"");
    }
}
