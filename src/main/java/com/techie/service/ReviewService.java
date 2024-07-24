package com.techie.service;

import com.cloudinary.*;
import com.cloudinary.utils.*;
import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.events.*;
import com.techie.exceptions.*;
import com.techie.repository.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.data.domain.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final ProductService productService;
    private final Cloudinary cloudinary;
    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserService userService,
                         ProductService productService, Cloudinary cloudinary,
                         ApplicationEventPublisher eventPublisher) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.productService = productService;
        this.cloudinary = cloudinary;
        this.eventPublisher = eventPublisher;
    }

    public List<ReviewModel> getReviewsForProduct(Long productId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Review> reviews = reviewRepository.findByProductId(productId, pageable);
        return reviews.stream()
                .filter(review -> review.getComment() != null && !review.getComment().isEmpty())
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    public ReviewModel convertToModel(Review review) {
        UserEntity user = userService.findByUsername(review.getUser().getEmail());  // To eagerly fetch the user's roles
        UserDisplayView userDisplayView = userService.convertToView(user);

        return ReviewModel.builder()
                .id(review.getId())
                .reviewer(userDisplayView)
                .productId(review.getProduct().getId())
                .productRating(review.getProductRating())
                .comment(review.getComment() != null ? review.getComment() : "")
                .imageUrls(review.getImageUrls() != null ?
                        review.getImageUrls().stream()
                                .map(ReviewImage::getImageUrl)
                                .collect(Collectors.toList())
                        : new ArrayList<>())
                .date(formatDateTime(review))
                .upvote(review.getUpvote())
                .downvote(review.getDownvote())
                .build();
    }

    @Transactional
    public void createReview(String comment, int rating, Long productId, MultipartFile[] images, UserDetails userDetails)
            throws ProductNotFoundException, IOException, InvalidRatingException, OneReviewPerUserException {

        Product product = getProductById(productId);
        UserEntity user = getUserByUsername(userDetails.getUsername());

        checkIfUserAlreadyReviewedProduct(user, product);
        validateRating(rating, productId);

        Review review = createReview(comment, rating, product, user);
        List<ReviewImage> reviewImages = uploadImages(images, productId, review);

        review.setImageUrls(reviewImages);
        Review savedReview = reviewRepository.save(review);
        eventPublisher.publishEvent(new ReviewCreatedEvent(savedReview.getId()));
        convertToModel(savedReview);
    }

    private String formatDateTime(Review review) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return review.getTimestamp().format(formatter);
    }

    private Product getProductById(Long productId) throws ProductNotFoundException {
        return productService.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
    }

    private UserEntity getUserByUsername(String username) {
        return userService.findByUsername(username);
    }

    private void checkIfUserAlreadyReviewedProduct(UserEntity user, Product product) throws OneReviewPerUserException {
        if (reviewRepository.existsByUserAndProduct(user, product)) {
            throw new OneReviewPerUserException();
        }
    }

    private void validateRating(int rating, Long productId) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            logger.warn("Invalid rating: {} for product ID: {}", rating, productId);
            throw new InvalidRatingException(rating);
        }
    }

    private Review createReview(String comment, int rating, Product product, UserEntity user) {
        Review review = new Review();
        review.setComment(comment);
        review.setProductRating(rating);
        review.setProduct(product);
        review.setUser(user);
        review.setTimestamp(LocalDateTime.now());
        return review;
    }

    @SuppressWarnings("unchecked")
    private List<ReviewImage> uploadImages(MultipartFile[] images, Long productId, Review review) throws IOException {
        List<ReviewImage> reviewImages = new ArrayList<>();
        if (images != null) {
            for (MultipartFile image : images) {
                try {
                    Map<String, Object> uploadResult = (Map<String, Object>) cloudinary.uploader().upload(image.getBytes(), ObjectUtils.asMap(
                            "folder", "reviews/" + productId));
                    String imageUrl = (String) uploadResult.get("secure_url");

                    ReviewImage reviewImage = new ReviewImage();
                    reviewImage.setImageUrl(imageUrl);
                    reviewImage.setReview(review);
                    reviewImages.add(reviewImage);
                } catch (IOException e) {
                    logger.error("Error uploading image to Cloudinary: ", e);
                    throw new IOException("Error uploading image to Cloudinary", e);
                }
            }
        }
        return reviewImages;
    }

    /**
     * Asynchronously updates the average rating of a product associated with a review.
     * This method creates a new transaction to ensure database operations are properly managed.
     *
     * @param reviewId The ID of the review that triggered the update
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateProductAverageRatingAsync(Long reviewId) {
        updateProductAverageRating(reviewId);
    }

    /**
     * Updates the average rating of a product associated with a review.
     * This method performs the actual calculation and update.
     */
    public void updateProductAverageRating(Long reviewId) {
        Review review = reviewRepository.findByIdWithProduct(reviewId);
        Long productId = review.getProduct().getId();
        Double averageRating = reviewRepository.calculateAverageRatingByProductId(productId);
        productService.updateAverageRating(productId, averageRating);
    }
}
