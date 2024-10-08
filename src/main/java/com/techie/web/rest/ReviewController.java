package com.techie.web.rest;

import com.techie.domain.model.models.*;
import com.techie.domain.model.requests.*;
import com.techie.exceptions.other.*;
import com.techie.exceptions.product.*;
import com.techie.exceptions.review.*;
import com.techie.exceptions.role.*;
import com.techie.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.lang.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.support.*;

import java.net.*;
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
    public ResponseEntity<?> getReviews(@PathVariable Long productId,
                                        @RequestParam(name = "p") int page,
                                        @RequestParam(name= "s") int size,
                                        @AuthenticationPrincipal @Nullable UserDetails userDetails) {
        try {
            List<ReviewModel> reviews = reviewService.getReviewsForProduct(productId, page, size, userDetails);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            logger.error("Error fetching reviews for product {}: {}", productId, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching reviews");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createReview(@RequestParam(value = "review-comment", required = false) String comment,
                                          @RequestParam("rate") int rating,
                                          @RequestParam("productId") Long productId,
                                          @RequestParam(value = "image-upload", required = false) MultipartFile[] images,
                                          @AuthenticationPrincipal UserDetails userDetails) {
        try {
            ReviewModel createdReview = reviewService.createReview(comment, rating, productId, images, userDetails);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdReview.getId()).toUri();
            return ResponseEntity.created(location).body("Review successfully created!");
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (InvalidRatingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (OneReviewPerUserException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/update/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId,
                                          @RequestBody ReviewUpdateRequest updateRequest,
                                          @AuthenticationPrincipal UserDetails userDetails)
                                             throws CloudinaryImageDeletionException, ReviewNotFoundException, UnauthorizedException {
        try {
            ReviewModel updatedReview = reviewService.updateReview(reviewId, updateRequest, userDetails);
            return ResponseEntity.ok(updatedReview);
        } catch (ReviewNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());  // 403 status code
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the review");
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId,
                                          @AuthenticationPrincipal UserDetails userDetails)
                                             throws CloudinaryImageDeletionException, ReviewNotFoundException, UnauthorizedException {
        try {
            reviewService.deleteReview(reviewId, userDetails);
            return ResponseEntity.ok("Review successfully deleted");
        } catch (ReviewNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the review");
        }
    }

    @PatchMapping("/vote/{reviewId}")
    public ResponseEntity<?> voteReview(@PathVariable Long reviewId,
                                        @RequestParam boolean isUpvote,
                                        @AuthenticationPrincipal UserDetails userDetails) {
        try {
            ReviewModel updatedReview = reviewService.voteReview(reviewId, isUpvote, userDetails);
            return ResponseEntity.ok(updatedReview);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}