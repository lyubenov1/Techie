package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<List<ReviewModel>> getReviews(@PathVariable Long productId,
                                                        @RequestParam(name = "p") int page,
                                                        @RequestParam(name= "s") int size) {
        logger.info("Fetching reviews for product ID: {}, page: {}, size: {}", productId, page, size);
        List<ReviewModel> reviews = reviewService.getReviewsForProduct(productId, page, size);
        logger.info("Retrieved {} reviews", reviews.size());
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestParam(value = "review-comment", required = false) String comment,
                                                    @RequestParam("rate") int rating,
                                                    @RequestParam("productId") Long productId,
                                                    @RequestParam(value = "image-upload", required = false) MultipartFile[] images,
                                                    @AuthenticationPrincipal UserDetails userDetails)
                                                        throws InvalidRatingException, OneReviewPerUserException, IOException {
        try {
            reviewService.createReview(comment, rating, productId, images, userDetails);
            return ResponseEntity.ok("Review successfully created!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/update/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId,
                                          @RequestBody ReviewUpdateRequest updateRequest,
                                          @AuthenticationPrincipal UserDetails userDetails) {
        try {
            ReviewModel updatedReview = reviewService.updateReview(reviewId, updateRequest, userDetails);
            return ResponseEntity.ok(updatedReview);
        } catch (Exception e) {
            logger.error("Error updating review: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
