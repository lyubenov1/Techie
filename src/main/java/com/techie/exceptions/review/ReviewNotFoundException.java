package com.techie.exceptions.review;

import com.techie.exceptions.*;

public class ReviewNotFoundException extends ObjectNotFoundException {
    public ReviewNotFoundException(Long reviewId) {
        super("Review with ID \"" + reviewId + "\" not found");
    }
}