package com.techie.exceptions.review;

public class OneReviewPerUserException extends RuntimeException {
    public OneReviewPerUserException() {
        super("You can give a maximum of one review per product. You can edit your current one.");
    }
}
