package com.techie.events;

/**
 * Event that is published when a new review is created.
 * It is used to trigger asynchronous processing of the review, such as updating product ratings.
 */
public record ReviewCreatedEvent(Long reviewId) {}