package com.techie.exceptions.product;

public class NotEnoughInStockException extends RuntimeException {
    public NotEnoughInStockException() {
        super("Not enough quantity in stock");
    }
}
