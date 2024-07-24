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
                .filter(review ->
                        (review.getComment() != null && !review.getComment().isEmpty()) ||
                                (review.getImageUrls() != null && !review.getImageUrls().isEmpty()))
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


    @Transactional
    public ReviewModel updateReview(Long reviewId, ReviewUpdateRequest updateRequest, UserDetails userDetails) {
        logger.info("Starting review update for reviewId: {}", reviewId);
        try {
            Review review = reviewRepository.findByIdJoinFetch(reviewId)
                    .orElseThrow(() -> new ReviewNotFoundException(reviewId));

            // Check if the user is authorized to update this review
            if (!review.getUser().getEmail().equals(userDetails.getUsername()) &&
                    userDetails.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN") || a.getAuthority().equals("ROLE_MODERATOR"))) {
                throw new UnauthorizedException("You are not authorized to update this review");
            }

            logger.info("Updating review content for reviewId: {}", reviewId);
            if (updateRequest.getComment() != null) {
                review.setComment(updateRequest.getComment());
            }
            if (updateRequest.getRating() != null) {
                review.setProductRating(updateRequest.getRating());
            }

            logger.info("Updating review images for reviewId: {}", reviewId);
            if (updateRequest.getRemainingImageUrls() != null) {
                updateReviewImages(review, updateRequest.getRemainingImageUrls());
            }

            logger.info("Saving updated review for reviewId: {}", reviewId);
            review = reviewRepository.save(review);

            logger.info("Review update completed for reviewId: {}", reviewId);
            return convertToModel(review);
        } catch (Exception e) {
            logger.error("Error occurred while updating review with id: {}", reviewId, e);
            throw e;
        }
    }

    private void updateReviewImages(Review review, List<String> remainingImageUrls) {
        List<ReviewImage> currentImages = review.getImageUrls();
        List<ReviewImage> imagesToRemove = new ArrayList<>();

        // Identify images to remove
        for (ReviewImage image : currentImages) {
            boolean imageFound = remainingImageUrls.stream()
                    .anyMatch(url -> url.contains(extractPublicIdFromUrl(image.getImageUrl())));
            if (!imageFound) {
                imagesToRemove.add(image);
            }
        }

        // Remove images from Cloudinary and the review
        for (ReviewImage image : imagesToRemove) {
            deleteImageFromCloudinary(image.getImageUrl());
            currentImages.remove(image);
        }

        review.setImageUrls(currentImages);
    }

    private void deleteImageFromCloudinary(String imageUrl) {
        try {
            String publicId = extractPublicIdFromUrl(imageUrl);
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (IOException e) {
            logger.error("Error deleting image from Cloudinary: ", e);
        }
    }

    private String extractPublicIdFromUrl(String imageUrl) {
        // Remove any query parameters
        String urlWithoutParams = imageUrl.split("\\?")[0];

        // Split the URL
        String[] urlParts = urlWithoutParams.split("/");

        // Find the index of "upload" in the URL parts
        int uploadIndex = -1;
        for (int i = 0; i < urlParts.length; i++) {
            if (urlParts[i].equals("upload")) {
                uploadIndex = i;
                break;
            }
        }

        if (uploadIndex == -1 || uploadIndex == urlParts.length - 1) {
            throw new IllegalArgumentException("Invalid Cloudinary URL structure");
        }

        // Construct the public ID
        StringBuilder publicId = new StringBuilder();
        for (int i = uploadIndex + 1; i < urlParts.length; i++) {
            if (i > uploadIndex + 1) publicId.append("/");
            publicId.append(urlParts[i]);
        }

        // Remove file extension
        String result = publicId.toString();
        int lastDotIndex = result.lastIndexOf('.');
        if (lastDotIndex != -1) {
            result = result.substring(0, lastDotIndex);
        }

        return result;
    }
}
