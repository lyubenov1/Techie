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
                                (review.getImages() != null && !review.getImages().isEmpty()))
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
                .imageUrls(review.getImages() != null ?
                        review.getImages().stream()
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

        //checkIfUserAlreadyReviewedProduct(user, product);
        validateRating(rating, productId);

        Review review = createReview(comment, rating, product, user);
        List<ReviewImage> reviewImages = uploadImages(images, productId, review);

        review.setImages(reviewImages);
        Review savedReview = reviewRepository.save(review);
        eventPublisher.publishEvent(new ReviewEvent(productId));
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

    //private void checkIfUserAlreadyReviewedProduct(UserEntity user, Product product) throws OneReviewPerUserException {
    //    if (reviewRepository.existsByUserAndProduct(user, product)) {
    //        throw new OneReviewPerUserException();
    //    }
    //}

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
                    String imageUrl = uploadResult.get("secure_url").toString();
                    String publicId = uploadResult.get("public_id").toString();

                    ReviewImage reviewImage = new ReviewImage();
                    reviewImage.setImageUrl(imageUrl);
                    reviewImage.setReview(review);
                    reviewImage.setPublicId(publicId);
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
     * @param productId The ID of the product that needs its average rating to be updated
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateProductAverageRatingAsync(Long productId) {
        updateProductAverageRating(productId);
    }

    /**
     * Updates the average rating of a product associated with a review.
     * This method performs the actual calculation and update.
     */
    public void updateProductAverageRating(Long productId) {
        Double averageRating = reviewRepository.calculateAverageRatingByProductId(productId);
        productService.updateAverageRating(productId, averageRating);
    }


    @Transactional
    public ReviewModel updateReview(Long reviewId, ReviewUpdateRequest updateRequest, UserDetails userDetails)
                                      throws CloudinaryImageDeletionException, ReviewNotFoundException, UnauthorizedException {
        Review review = reviewRepository.findByIdJoinFetch(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        // Check if the user is authorized to update this review
        if (!review.getUser().getEmail().equals(userDetails.getUsername())) {
            throw new UnauthorizedException("You are not authorized to update this review");
        }

        if (updateRequest.getComment() != null) {
            review.setComment(updateRequest.getComment());
        }
        if (updateRequest.getRating() != null) {
            review.setProductRating(updateRequest.getRating());
        }
        if (updateRequest.getRemainingImageUrls() != null) {
            updateReviewImages(review, updateRequest.getRemainingImageUrls());
        }

        review = reviewRepository.save(review);
        eventPublisher.publishEvent(new ReviewEvent(review.getProduct().getId()));
        return convertToModel(review);
    }

    private void updateReviewImages(Review review, List<String> remainingImageUrls) {
        List<ReviewImage> currentImages = review.getImages();
        List<ReviewImage> imagesToRemove = new ArrayList<>();

        // Identify images to remove
        for (ReviewImage image : currentImages) {
            boolean imageFound = remainingImageUrls.stream()
                    .anyMatch(url -> url.contains(image.getPublicId()));
            if (!imageFound) {
                imagesToRemove.add(image);
            }
        }

        // Remove images from Cloudinary and the review
        for (ReviewImage image : imagesToRemove) {
            deleteImageFromCloudinary(image.getPublicId());
            currentImages.remove(image);
        }

        review.setImages(currentImages);
    }

    private void deleteImageFromCloudinary(String publicId) {
        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.asMap("invalidate", "true"));
        } catch (IOException e) {
            logger.error("Error deleting image from Cloudinary: publicId={}, error={}", publicId, e.getMessage(), e);
            throw new CloudinaryImageDeletionException("Failed to delete image: " + publicId);
        }
    }

    @Transactional
    public void deleteReview(Long reviewId, UserDetails userDetails) throws ReviewNotFoundException, UnauthorizedException, CloudinaryImageDeletionException {
        Review review = reviewRepository.findByIdWithProduct(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        // Check if the user is authorized to delete this review
        if (!review.getUser().getEmail().equals(userDetails.getUsername()) &&
                userDetails.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN") || a.getAuthority().equals("ROLE_MODERATOR"))) {
            throw new UnauthorizedException("You are not authorized to delete this review");
        }

        // Delete associated images from Cloudinary
        deleteImagesFromCloudinary(review);

        // Delete the review from the database
        reviewRepository.delete(review);
        eventPublisher.publishEvent(new ReviewEvent(review.getProduct().getId()));
    }

    private void deleteImagesFromCloudinary(Review review) {
        if (review.getImages() != null && !review.getImages().isEmpty()) {
            List<String> publicIds = review.getImages().stream()
                    .map(ReviewImage::getPublicId)
                    .collect(Collectors.toList());

            try {
                Map<String, Object> params = new HashMap<>();
                params.put("public_ids", publicIds);
                params.put("invalidate", true);

                cloudinary.api().deleteResources(publicIds, params);
            } catch (Exception e) {
                logger.error("Error deleting images from Cloudinary: ", e);
                throw new CloudinaryImageDeletionException("Failed to delete images: " + publicIds);
            }
        }
    }
}
