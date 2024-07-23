package com.techie.exceptions;

public class InvalidRatingException extends RuntimeException {
    public InvalidRatingException(int ratingValue) {
        super("Rating value \"" + ratingValue + "\" is invalid.");
    }
}
