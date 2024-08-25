package com.techie.web.rest;

import com.fasterxml.jackson.databind.*;
import com.techie.config.*;
import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.repository.*;
import com.techie.service.*;
import com.techie.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
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
public class CartControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @MockBean
    private RoleAdder roleAdder;

    @Test
    @WithMockUser(username = "testadmin@example.com")
    void testAddToCart_AuthenticatedUser_Success() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(2L);
        productDTO.setName("iPhone 15 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(1L);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(2L);

        mockMvc.perform(post("/api/cart/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.productId").value(itemDTO.getProductId()))
                .andExpect(jsonPath("$.quantity").value(1));
    }

    @Test
    void testAddToCart_AnonymousUser_Success() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(2L);
        productDTO.setName("iPhone 15 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(1L);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(2L);

        mockMvc.perform(post("/api/cart/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.productId").value(itemDTO.getProductId()))
                .andExpect(jsonPath("$.quantity").value(1));
    }

    @Test
    void testAnonymousCartPersistence() throws Exception {
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setId(1L);
        productDTO1.setName("iPhone 14 Pro");

        CartItemDTO itemDTO1 = new CartItemDTO();
        itemDTO1.setId(1L);
        itemDTO1.setProduct(productDTO1);
        itemDTO1.setProductId(1L);

        mockMvc.perform(post("/api/cart/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO1))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andReturn();

        // Second request: Add another item to the cart
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setId(2L);
        productDTO2.setName("iPhone 15 Pro");

        CartItemDTO itemDTO2 = new CartItemDTO();
        itemDTO2.setId(2L);
        itemDTO2.setProduct(productDTO2);
        itemDTO2.setProductId(2L);

        mockMvc.perform(post("/api/cart/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO2))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andReturn();

        // Verify the cart contains both items
        mockMvc.perform(get("/api/cart/get")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartItems.length()").value(2))
                .andExpect(jsonPath("$.cartItems[0].product.id").value(productDTO1.getId()))
                .andExpect(jsonPath("$.cartItems[1].product.id").value(productDTO2.getId()));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    void testAnonymousToAuthenticatedCartMerge() throws Exception {
        String anonymousCartId = "787b105b-8e76-4594-8263-5748b9f7477d";

        // Simulate the GET request
        MvcResult result = mockMvc.perform(get("/api/cart/get")
                        .sessionAttr("anonymousCartId", anonymousCartId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Parse the response
        String content = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        CartDTO cartDTO = objectMapper.readValue(content, CartDTO.class);

        // Assert the results
        Assertions.assertNotNull(cartDTO);
        Assertions.assertEquals(2, cartDTO.getCartItems().size());

        // Check merged quantities
        for (CartItemDTO item : cartDTO.getCartItems()) {
            if (item.getProduct().getId() == 1L) {
                Assertions.assertEquals(4, item.getQuantity()); // 3 from user cart + 1 from anonymous cart
            } else if (item.getProduct().getId() == 2L) {
                Assertions.assertEquals(3, item.getQuantity()); // 3 from anonymous cart
            } else {
                Assertions.fail("Unexpected product in merged cart");
            }
        }

        // Verify anonymous cart is deleted
        Assertions.assertFalse(cartRepository.findByAnonymousId(anonymousCartId).isPresent());
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testAddToCart_Failure_NotEnoughInStock() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(4L);
        productDTO.setName("iPhone 11");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(1L);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(4L);

        mockMvc.perform(post("/api/cart/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("Not enough quantity in stock"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testAddToCart_Failure_ProductAlreadyInCart() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(1L);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        mockMvc.perform(post("/api/cart/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("Product is already added to your cart. You can adjust the quantity before checkout"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testAddToCart_Failure_InternalError() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(91L);
        productDTO.setName("NonExistingProduct");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(1L);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(91L);

        mockMvc.perform(post("/api/cart/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An unexpected error occurred"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testUpdateCartItem_Success() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(100L);
        itemDTO.setQuantity(5);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        // Perform the update request
        mockMvc.perform(patch("/api/cart/items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully updated quantity"));

        Cart cart = cartRepository.findByUserEmail("testuser@example.com").orElseThrow();

        int totalQuantity = cart.getCartItems().stream()
                .mapToInt(CartItem::getQuantity)  // Map each CartItem to its quantity
                .sum();  // Sum all the quantities

        Assertions.assertEquals(6, totalQuantity);
    }


    @Test
    @WithMockUser(username = "testuser@example.com")
    void testUpdateCartItem_Failure_NotEnoughInStock() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(3L);
        productDTO.setName("iPhone X");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(101L);
        itemDTO.setQuantity(5);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(3L);

        mockMvc.perform(patch("/api/cart/items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("Not enough quantity in stock"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testUpdateCartItem_Failure_InternalError() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(680L);
        itemDTO.setQuantity(5);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        mockMvc.perform(patch("/api/cart/items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An unexpected error occurred"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testGetCart_Success() throws Exception {
        // First update the user cart. This is done for the grandTotal field to be calculated
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(100L);
        itemDTO.setQuantity(4);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        // Perform the update request
        mockMvc.perform(patch("/api/cart/items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully updated quantity"));

        mockMvc.perform(get("/api/cart/get")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartItems").isArray())
                .andExpect(jsonPath("$.grandTotal").value(4499.95));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testRemoveCartItem_Success() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(100L);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        mockMvc.perform(delete("/api/cart/items/remove")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Cart item has been removed"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testRemoveCartItem_Failure_InternalError() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(190L);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        mockMvc.perform(delete("/api/cart/items/remove")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An unexpected error occurred"));
    }
}
