package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewModel>> getReviews(@PathVariable Long productId,
                                                        @RequestParam(name = "p") int page,
                                                        @RequestParam(name= "s") int size) {
        List<ReviewModel> reviews = reviewService.getReviewsForProduct(productId, page, size);
        return ResponseEntity.ok(reviews);
    }

}
