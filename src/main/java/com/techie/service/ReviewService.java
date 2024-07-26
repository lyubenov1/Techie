package com.techie.service;

import com.cloudinary.*;
import com.cloudinary.utils.*;
import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
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
    private final ReviewVoteRepository voteRepository;
    private final Cloudinary cloudinary;
    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserService userService,
                         ProductService productService, ReviewVoteRepository voteRepository,
                         Cloudinary cloudinary, ApplicationEventPublisher eventPublisher) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.productService = productService;
        this.voteRepository = voteRepository;
        this.cloudinary = cloudinary;
        this.eventPublisher = eventPublisher;
    }

    public List<ReviewModel> getReviewsForProduct(Long productId, int page, int size, UserDetails userDetails) {
        Page<Review> reviews = reviewRepository.findByProductId(productId, PageRequest.of(page, size));

        return reviews.stream()
                .filter(review ->
                        (review.getComment() != null && !review.getComment().isEmpty()) ||
                                (review.getImages() != null && !review.getImages().isEmpty()))
                .map(review -> {
                    ReviewModel model = convertToModel(review);
                    return setVotesToModel(model, review, userDetails);  // Set the vote state for each review for the currently logged user. Handles unauthenticated users also.
                })
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
                .userVote(VoteStatus.NONE)  // Default value
                .build();
    }

    private ReviewModel setVotesToModel(ReviewModel model, Review review, UserDetails userDetails) {
        if (userDetails != null) {
            UserEntity currentUser = userService.findByUsernameWithRoles(userDetails.getUsername());
            VoteStatus userVote = getVote(currentUser, review);
            model.setUserVote(userVote);
        }
        return model;
    }

    private VoteStatus getVote(UserEntity currentUser, Review review) {
        return voteRepository.findByUserAndReview(currentUser, review)
                .map(userVote -> userVote.isUpvote() ? VoteStatus.UP : VoteStatus.DOWN)
                .orElse(VoteStatus.NONE);
    }

    @Transactional
    public void createReview(String comment, int rating, Long productId, MultipartFile[] images, UserDetails userDetails)
            throws ProductNotFoundException, IOException, InvalidRatingException, OneReviewPerUserException {

        Product product = getProductById(productId);
        UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());

        checkIfUserAlreadyReviewedProduct(user, product);
        validateRating(rating, productId);

        Review review = createReview(comment, rating, product, user);
        List<ReviewImage> reviewImages = uploadImages(images, productId, review);

        review.setImages(reviewImages);
        Review savedReview = reviewRepository.save(review);
        eventPublisher.publishEvent(new ReviewEvent(productId));  // // Event which updates the product's average rating
        convertToModel(savedReview);
    }

    private String formatDateTime(Review review) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return review.getTimestamp().format(formatter);
    }

    private Product getProductById(Long productId) throws ProductNotFoundException {
        return productService.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
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

    private List<ReviewImage> uploadImages(MultipartFile[] images, Long productId, Review review) throws IOException {
        List<ReviewImage> reviewImages = new ArrayList<>();
        // Check if images are provided
        if (images == null || images.length == 0) {
            return reviewImages;
        }
        String folderPath = "reviews/" + productId;

        for (MultipartFile image : images) {
            if (image.isEmpty()) {
                continue;  // Skip empty files
            }
            try {
                // Upload image to Cloudinary
                Map<String, Object> uploadResult = uploadToCloudinary(image, folderPath);

                // Create and configure ReviewImage object
                ReviewImage reviewImage = createReviewImage(uploadResult, review);
                reviewImages.add(reviewImage);
            } catch (IOException e) {
                logger.error("Error uploading image to Cloudinary: ", e);
                throw new IOException("Error uploading image to Cloudinary", e);
            }
        }
        return reviewImages;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> uploadToCloudinary(MultipartFile image, String folderPath) throws IOException {
        return (Map<String, Object>) cloudinary.uploader().upload(
                image.getBytes(),
                ObjectUtils.asMap("folder", folderPath)  // Cloudinary upload method from their upload API
        );
    }

    private ReviewImage createReviewImage(Map<String, Object> uploadResult, Review review) {
        String imageUrl = (String) uploadResult.get("secure_url");
        String publicId = (String) uploadResult.get("public_id");

        ReviewImage reviewImage = new ReviewImage();
        reviewImage.setImageUrl(imageUrl);
        reviewImage.setReview(review);
        reviewImage.setPublicId(publicId);

        return reviewImage;
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
        eventPublisher.publishEvent(new ReviewEvent(review.getProduct().getId()));  // Event which updates the product's average rating
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
            cloudinary.uploader().destroy(publicId, ObjectUtils.asMap("invalidate", "true"));  // destroy method of Cloudinary's upload API
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

        // Delete associated review votes
        voteRepository.deleteByReviewId(reviewId);

        // Delete the review from the database
        reviewRepository.delete(review);
        eventPublisher.publishEvent(new ReviewEvent(review.getProduct().getId()));  // Event which updates the product's average rating
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

                cloudinary.api().deleteResources(publicIds, params);  // deleteResources method of Cloudinary's Admin API. It deletes all associated files
            } catch (Exception e) {
                logger.error("Error deleting images from Cloudinary: ", e);
                throw new CloudinaryImageDeletionException("Failed to delete images: " + publicIds);
            }
        }
    }

    @Transactional
    public ReviewModel voteReview(Long reviewId, boolean isUpvote, UserDetails userDetails) {
        // Fetch the user and review
        UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        // Find existing vote or create a new one
        ReviewVote vote = voteRepository.findByUserAndReview(user, review)
                .orElse(new ReviewVote());

        if (vote.getId() == null) {
            handleNewVote(vote, user, review, isUpvote);
        } else if (vote.isUpvote() == isUpvote) {
            handleVoteRemoval(vote, review, isUpvote);
        } else {
            handleVoteChange(vote, review, isUpvote);
        }

        // Convert the updated review to a model and set vote information
        ReviewModel reviewModel = convertToModel(review);
        setVotesToModel(reviewModel, review, userDetails);
        return reviewModel;
    }

    private void handleNewVote(ReviewVote vote, UserEntity user, Review review, boolean isUpvote) {
        // Set up and save the new vote
        vote.setUser(user);
        vote.setReview(review);
        vote.setUpvote(isUpvote);
        voteRepository.save(vote);

        // Update the review's vote count
        updateReviewVoteCount(review, isUpvote, true);
    }

    private void handleVoteRemoval(ReviewVote vote, Review review, boolean isUpvote) {
        // Remove the existing vote if it's the same type
        voteRepository.delete(vote);
        updateReviewVoteCount(review, isUpvote, false);
    }

    private void handleVoteChange(ReviewVote vote, Review review, boolean isUpvote) {
        // Remove the old vote count
        updateReviewVoteCount(review, vote.isUpvote(), false);

        // Change the vote type
        vote.setUpvote(isUpvote);
        voteRepository.save(vote);

        // Add the new vote count
        updateReviewVoteCount(review, isUpvote, true);
    }

    private void updateReviewVoteCount(Review review, boolean isUpvote, boolean isIncrement) {
        int voteChange = isIncrement ? 1 : -1;

        if (isUpvote) {
            review.setUpvote(review.getUpvote() + voteChange);
        } else {
            review.setDownvote(review.getDownvote() + voteChange);
        }
        reviewRepository.save(review);
    }
}
