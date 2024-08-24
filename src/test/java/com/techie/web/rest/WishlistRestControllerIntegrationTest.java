package com.techie.web.rest;

import com.techie.config.*;
import com.techie.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.security.test.context.support.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import org.springframework.test.context.*;
import org.springframework.test.context.jdbc.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.cache.type=none",
        "spring.main.allow-bean-definition-overriding=true"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class WishlistRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private UserService userService;

    @MockBean
    private RoleAdder roleAdder;

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testGetWishlists_Success() throws Exception {
        mockMvc.perform(get("/api/wishlist/get")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Test user wishlist"))
                .andExpect(jsonPath("$[0].products").isArray())
                .andExpect(jsonPath("$[0].products.length()").value(2))
                .andExpect(jsonPath("$[0].products[0].name").value("iPhone 14 Pro"))
                .andExpect(jsonPath("$[0].products[1].name").value("iPhone 15 Pro"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    void testAddToWishlist_Success() throws Exception {
        mockMvc.perform(patch("/api/wishlist/add/{wishlistId}/{productId}", 2L, 2L)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Product successfully added to wishlist"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    void testAddToWishlist_Failure_ProductNotFound() throws Exception {
        mockMvc.perform(patch("/api/wishlist/add/{wishlistId}/{productId}", 2L, 100L)
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product with ID \"" + "100" + "\" not found"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testAddToWishlist_Failure_WishlistNotFound() throws Exception {
        mockMvc.perform(patch("/api/wishlist/add/{wishlistId}/{productId}", 27L, 100L)
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Wishlist not found with ID: 27"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testAddToWishlist_Failure_ProductAlreadyInWishlist() throws Exception {
        mockMvc.perform(patch("/api/wishlist/add/{wishlistId}/{productId}", 1L, 1L)
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("Product \"" + "iPhone 14 Pro" + "\" already exists in wishlist \"" + "Test user wishlist" + "\""));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testRemoveFromWishlist_Success() throws Exception {
        mockMvc.perform(delete("/api/wishlist/remove/{wishlistId}/{productId}", 1L, 1L)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Product successfully removed from wishlist"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testRemoveFromWishlist_Failure_WishlistNotFound() throws Exception {
        mockMvc.perform(delete("/api/wishlist/remove/{wishlistId}/{productId}", 61L, 1L)
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Wishlist not found with ID: 61"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testRemoveFromWishlist_Failure_ProductNotFound() throws Exception {
        mockMvc.perform(delete("/api/wishlist/remove/{wishlistId}/{productId}", 1L, 100L)
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product with ID \"" + "100" + "\" not found"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testRemoveAllFromWishlist_Success() throws Exception {
        mockMvc.perform(delete("/api/wishlist/removeAll/{wishlistId}", 1L)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("All products successfully removed from wishlist"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testRemoveAllFromWishlist_Failure_WishlistNotFound() throws Exception {
        mockMvc.perform(delete("/api/wishlist/removeAll/{wishlistId}", 27L)
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Wishlist not found with ID: 27"));
    }

}
