package com.techie.exceptions;

public class ProductNotInWishlistException extends RuntimeException {
    public ProductNotInWishlistException(String productName, String wishlistName) {
        super("Product \"" + productName + "\" doesn't exist in wishlist \"" + wishlistName + "\"");
    }
}
