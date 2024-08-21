package com.techie.web.rest;

import com.techie.config.*;
import com.techie.domain.entities.*;
import com.techie.domain.model.requests.*;
import com.techie.repository.*;
import com.techie.service.*;
import com.techie.utils.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.mock.web.*;
import org.springframework.security.test.context.support.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import org.springframework.test.context.*;
import org.springframework.test.context.jdbc.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "spring.cache.type=none",
        "spring.main.allow-bean-definition-overriding=true"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ReviewControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewVoteRepository voteRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewImageRepository reviewImageRepository;

    @MockBean
    private RoleAdder roleAdder;

    @Test
    void testGetReviews_AnonymousUser_Success() throws Exception {
        mockMvc.perform(get("/api/reviews/get/{productId}", 1L)
                        .param("p", "0")
                        .param("s", "7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].userVote").value("NONE"))
                .andExpect(jsonPath("$[1].userVote").value("NONE"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testGetReviews_AuthenticatedUser_Success() throws Exception {
        mockMvc.perform(get("/api/reviews/get/{productId}", 1L)
                        .param("p", "0")
                        .param("s", "7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].userVote").value("DOWN"))
                .andExpect(jsonPath("$[1].userVote").value("NONE"));
    }

    @Test
    @WithAnonymousUser
    void testCreateReview_AnonymousUser_Unauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews/create")
                        .param("review-comment", "Great product!")
                        .param("rate", "5")
                        .param("productId", "1"))
                .andExpect(status().isFound())  // Expect 302 Redirect
                .andExpect(header().string("Location", "/unauthorized"));
    }

    @Test
    @WithMockUser(username = "testnotblacklisted@example.com")
    void testCreateReview_Success() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "images",
                "test-image.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                "dummy-image-content".getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/reviews/create")
                        .file(file)
                        .param("review-comment", "Great product!")
                        .param("rate", "5")
                        .param("productId", "1")
                        .with(csrf())
                        .with(request -> {
                            request.setMethod("POST");
                            return request;
                        }))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(content().string("Review successfully created!"));

        // Additional verification that the event is published and handled
        // This is done by checking side effects of the event
        Double updatedAverageRating = productRepository.getProductAverageRating(1L);
        assertNotNull(updatedAverageRating);
        assertEquals(3.333, updatedAverageRating, 0.001);
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testCreateReview_OneReviewPerProductException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews/create")
                        .param("review-comment", "Great product!")
                        .param("rate", "5")
                        .param("productId", "1")
                        .with(csrf()))
                .andExpect(status().isForbidden())
                .andExpect(content().string("You can give a maximum of one review per product. You can edit your current one."));
    }

    @Test
    @WithMockUser(username = "testnotblacklisted@example.com")
    void testCreateReview_Failure_InvalidRating() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "image-upload",
                "test-image.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                "dummy-image-content".getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/reviews/create")
                        .file(file)
                        .param("review-comment", "Great product!")
                        .param("rate", "99")
                        .param("productId", "1")
                        .with(request -> {
                            request.setMethod("POST");
                            return request;
                        })
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Rating value \"" + 99 + "\" is invalid."));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testUpdateReview_Success() throws Exception {
        ReviewUpdateRequest updateRequest = new ReviewUpdateRequest();
        updateRequest.setRating(4);
        updateRequest.setComment("Updated comment");

        mockMvc.perform(patch("/api/reviews/update/{reviewId}", 11L)
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(updateRequest))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comment").value("Updated comment"))
                .andExpect(jsonPath("$.productRating").value(4));

        // Additional verification that the event is published and handled
        // This is done by checking side effects of the event
        Double updatedAverageRating = productRepository.getProductAverageRating(1L);
        assertNotNull(updatedAverageRating);
        assertEquals(4.0, updatedAverageRating, 0.001);
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    void testUpdateReview_AdminsCanNotUpdateOtherUsersReviews_Success() throws Exception {
        ReviewUpdateRequest updateRequest = new ReviewUpdateRequest();
        updateRequest.setRating(4);
        updateRequest.setComment("Updated comment");

        mockMvc.perform(patch("/api/reviews/update/{reviewId}", 11L)
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(updateRequest))
                        .with(csrf()))
                .andExpect(status().isForbidden())
                .andExpect(content().string("You are not authorized to update this review"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testUpdateReview_Failure_ReviewNotFound() throws Exception {
        ReviewUpdateRequest updateRequest = new ReviewUpdateRequest();

        mockMvc.perform(patch("/api/reviews/update/{reviewId}", 999L)
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(updateRequest))
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Review with ID \"" + 999 + "\" not found"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testDeleteReview_Success() throws Exception {
        mockMvc.perform(delete("/api/reviews/{reviewId}", 11L)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Review successfully deleted"));

        // Check if review is deleted
        assertFalse(reviewRepository.findById(11L).isPresent());

        // Check if review votes are deleted
        List<ReviewVote> votes = voteRepository.findByReviewId(11L);
        assertTrue(votes.isEmpty());

        // Check if review images are deleted
        List<ReviewImage> images = reviewImageRepository.findByReviewId(11L);
        assertTrue(images.isEmpty());

        // Verify updated average rating
        Double updatedAverageRating = productRepository.getProductAverageRating(1L);
        assertNotNull(updatedAverageRating);
        assertEquals(4.0, updatedAverageRating, 0.001);
    }


    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    void testDeleteReview_AdminsCanDeleteOtherUsersReviews_Success() throws Exception {
        mockMvc.perform(delete("/api/reviews/{reviewId}", 11L)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Review successfully deleted"));

        // Check if review is deleted
        assertFalse(reviewRepository.findById(11L).isPresent());

        // Check if review votes are deleted
        List<ReviewVote> votes = voteRepository.findByReviewId(11L);
        assertTrue(votes.isEmpty());

        // Check if review images are deleted
        List<ReviewImage> images = reviewImageRepository.findByReviewId(11L);
        assertTrue(images.isEmpty());

        // Verify updated average rating
        Double updatedAverageRating = productRepository.getProductAverageRating(1L);
        assertNotNull(updatedAverageRating);
        assertEquals(4.0, updatedAverageRating, 0.001);
    }

    @Test
    @WithMockUser(username = "testnotblacklisted@example.com")
    void testDeleteReview_Unauthorized() throws Exception {
        mockMvc.perform(delete("/api/reviews/{reviewId}", 11L)
                        .with(csrf()))
                .andExpect(status().isForbidden())
                .andExpect(content().string("You are not authorized to delete this review"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testDeleteReview_ReviewNotFound() throws Exception {
        mockMvc.perform(delete("/api/reviews/{reviewId}", 999L)
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Review with ID \"" + 999 + "\" not found"));
    }

    @Test
    @WithMockUser(username = "testnotblacklisted@example.com")
    void testVoteReview_Success() throws Exception {
        mockMvc.perform(patch("/api/reviews/vote/{reviewId}", 10L)
                        .param("isUpvote", "true")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.upvote").value(4))
                .andExpect(jsonPath("$.downvote").value(2))
                .andExpect(jsonPath("$.userVote").value("UP"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testVoteReview_ChangeVote_Success() throws Exception {
        ReviewVote initialVote = voteRepository.findByReviewIdAndUserId(10L, 2L);
        assertNotNull(initialVote, "Initial vote should not be null");
        assertFalse(initialVote.isUpvote(), "Initial vote should be a downvote");

        mockMvc.perform(patch("/api/reviews/vote/{reviewId}", 10L)
                        .param("isUpvote", "true")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.upvote").value(4))
                .andExpect(jsonPath("$.downvote").value(1))
                .andExpect(jsonPath("$.userVote").value("UP"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testVoteReview_RemoveVote_Success() throws Exception {
        ReviewVote initialVote = voteRepository.findByReviewIdAndUserId(10L, 2L);
        assertNotNull(initialVote, "Initial vote should not be null");
        assertFalse(initialVote.isUpvote(), "Initial vote should be a downvote");

        mockMvc.perform(patch("/api/reviews/vote/{reviewId}", 10L)
                        .param("isUpvote", "false")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.upvote").value(3))
                .andExpect(jsonPath("$.downvote").value(1))
                .andExpect(jsonPath("$.userVote").value("NONE"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testVoteReview_Failure_InternalError() throws Exception {
        mockMvc.perform(patch("/api/reviews/vote/{reviewId}", 999L)
                        .param("isUpvote", "true")
                        .with(csrf()))
                .andExpect(status().isInternalServerError());
    }
}