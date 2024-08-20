package com.techie.web.rest;

import com.techie.config.*;
import com.techie.domain.model.requests.*;
import com.techie.service.*;
import com.techie.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.mock.web.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.*;
import org.springframework.test.context.jdbc.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import({TestConfig.class})
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
    void testCreateReview_AnonymousUser_Unauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews/create")
                        .param("comment", "Great product!")
                        .param("rating", "5")
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
                        .with(request -> {
                            request.setMethod("POST");
                            return request;
                        }))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(content().string("Review successfully created!"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testCreateReview_OneReviewPerProductException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews/create")
                        .param("review-comment", "Great product!")
                        .param("rate", "5")
                        .param("productId", "1"))
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
                        }))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Rating value \"" + 99 + "\" is invalid."));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testUpdateReview_Success() throws Exception {
        ReviewUpdateRequest updateRequest = new ReviewUpdateRequest();
        updateRequest.setRating(4);
        updateRequest.setComment("Updated comment");

        mockMvc.perform(patch("/api/reviews/update/{reviewId}", 2L)
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comment").value("Updated comment"))
                .andExpect(jsonPath("$.productRating").value(4));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    void testUpdateReview_AdminsCanNotUpdateOtherUsersReviews_Success() throws Exception {
        ReviewUpdateRequest updateRequest = new ReviewUpdateRequest();
        updateRequest.setRating(4);
        updateRequest.setComment("Updated comment");

        mockMvc.perform(patch("/api/reviews/update/{reviewId}", 2L)
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(updateRequest)))
                .andExpect(status().isForbidden())
                .andExpect(content().string("You are not authorized to update this review"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testUpdateReview_Failure_ReviewNotFound() throws Exception {
        ReviewUpdateRequest updateRequest = new ReviewUpdateRequest();

        mockMvc.perform(patch("/api/reviews/update/{reviewId}", 999L)
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(updateRequest)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Review not found message from service"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testDeleteReview_Success() throws Exception {
        mockMvc.perform(delete("/api/reviews/{reviewId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().string("Review successfully deleted"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testDeleteReview_Failure_ReviewNotFound() throws Exception {
        mockMvc.perform(delete("/api/reviews/{reviewId}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Review not found message from service"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testVoteReview_Success() throws Exception {
        mockMvc.perform(patch("/api/reviews/vote/{reviewId}", 1L)
                        .param("isUpvote", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.upvotes").value(1)); // Assuming initial upvotes were 0
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testVoteReview_Failure_InternalError() throws Exception {
        mockMvc.perform(patch("/api/reviews/vote/{reviewId}", 999L)
                        .param("isUpvote", "true"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Internal server error message from service"));
    }
}