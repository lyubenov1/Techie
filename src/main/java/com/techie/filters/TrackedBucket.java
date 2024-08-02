package com.techie.filters;

import io.github.bucket4j.*;
import lombok.*;

/**
 * A wrapper class for Bucket4j's Bucket that tracks the last successful token consumption time.
 * This class is used to implement rate limiting with the ability to clean up unused buckets.
 */
public class TrackedBucket {
    private final Bucket bucket;

    /**
     * The timestamp of the last successful token consumption.
     */
    @Getter
    private long lastRefillTime;

    /**
     * Constructs a new TrackedBucket with the given Bucket4j Bucket.
     *
     * @param bucket The Bucket4j Bucket to wrap.
     */
    public TrackedBucket(Bucket bucket) {
        this.bucket = bucket;
        this.lastRefillTime = System.currentTimeMillis();
    }

    /**
     * Attempts to consume tokens from the bucket and updates the last refill time if successful.
     *
     * @param numTokens The number of tokens to consume.
     * @return A ConsumptionProbe containing the result of the consumption attempt.
     */
    public ConsumptionProbe tryConsumeAndReturnRemaining(long numTokens) {
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(numTokens);
        if (probe.isConsumed()) {
            this.lastRefillTime = System.currentTimeMillis();
        }
        return probe;
    }
}