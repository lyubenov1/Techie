package com.techie.events.listeners;

import com.techie.events.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.event.*;

@Component
public class ReviewListener {

    private static ReviewService reviewService;

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        ReviewListener.reviewService = reviewService;
    }

    /**
     * Listens for ReviewCreatedEvents and triggers the asynchronous update of the product's average rating.
     * This method is executed after the transaction that created the review is committed.
     * It runs asynchronously to avoid blocking the main thread.
     *
     * @param event The ReviewCreatedEvent containing the ID of the newly created review
     */
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onReviewChange(ReviewCreatedEvent event) {
        reviewService.updateProductAverageRatingAsync(event.reviewId());
    }
}