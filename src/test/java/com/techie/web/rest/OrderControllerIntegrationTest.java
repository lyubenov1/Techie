package com.techie.web.rest;

import com.fasterxml.jackson.databind.*;
import com.icegreen.greenmail.util.*;
import com.techie.config.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.DTOs.*;
import com.techie.domain.model.requests.*;
import com.techie.service.*;
import com.techie.utils.*;
import jakarta.mail.internet.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
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

import java.math.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.cache.type=none",
        "spring.main.allow-bean-definition-overriding=true"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @MockBean
    private RoleAdder roleAdder;

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private Integer mailPort;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Value("${spring.mail.password}")
    private String mailPassword;

    private GreenMail greenMail;

    @BeforeEach
    void setUp() {
        greenMail = new GreenMail(new ServerSetup(mailPort, mailHost, "smtp"));
        greenMail.start();
        greenMail.setUser(mailUsername, mailPassword);
    }

    @AfterEach
    void tearDown() {
        greenMail.stop();
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testCreateOrder_AuthenticatedUser_Success() throws Exception {
        // Create and set up the product DTO
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        // Create and set up the cart item DTO
        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(100L);
        itemDTO.setQuantity(4);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        // Perform the request to update the cart
        mockMvc.perform(patch("/api/cart/items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully updated quantity"));

        // Retrieve the cart and extract CartDTO
        MvcResult mvcResult = mockMvc.perform(get("/api/cart/get")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartItems").isArray())
                .andExpect(jsonPath("$.grandTotal").value(4499.95))
                .andReturn();

        // Extract the response content as a String
        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Convert the JSON response to CartDTO
        ObjectMapper objectMapper = new ObjectMapper();
        CartDTO cartDTO = objectMapper.readValue(jsonResponse, CartDTO.class);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotal(new BigDecimal("4499.95"));
        orderRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderRequest.setAddressId(50L);
        orderRequest.setCartDTO(cartDTO);

        mockMvc.perform(post("/api/order/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(orderRequest))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.grandTotal").value(orderRequest.getTotal()));

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the email was sent
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(1, receivedMessages.length);
        MimeMessage message = receivedMessages[0];

        assertEquals("Order successfully placed", message.getSubject());
        assertTrue(GreenMailUtil.getBody(message).contains("Credit Card"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testCreateOrder_AuthenticatedUser_Failure_InvalidAddress() throws Exception {
        // Create and set up the product DTO
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        // Create and set up the cart item DTO
        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(100L);
        itemDTO.setQuantity(4);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        // Perform the request to update the cart
        mockMvc.perform(patch("/api/cart/items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully updated quantity"));

        // Retrieve the cart and extract CartDTO
        MvcResult mvcResult = mockMvc.perform(get("/api/cart/get")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartItems").isArray())
                .andExpect(jsonPath("$.grandTotal").value(4499.95))
                .andReturn();

        // Extract the response content as a String
        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Convert the JSON response to CartDTO
        ObjectMapper objectMapper = new ObjectMapper();
        CartDTO cartDTO = objectMapper.readValue(jsonResponse, CartDTO.class);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotal(new BigDecimal("199.99"));
        orderRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderRequest.setAddressId(90L);
        orderRequest.setCartDTO(cartDTO);

        mockMvc.perform(post("/api/order/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(orderRequest))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid address"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testCreateOrder_AuthenticatedUser_Failure_InvalidOrder() throws Exception {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotal(new BigDecimal("0"));
        orderRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderRequest.setAddressId(50L);

        mockMvc.perform(post("/api/order/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(orderRequest))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("You can't place an empty order!"));
    }

    @Test
    void testCreateOrder_AnonymousUser_Success() throws Exception {
        String anonymousCartId = "787b105b-8e76-4594-8263-5748b9f7477d";

        // Create and set up the product DTO
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 15 Pro");

        // Create and set up the cart item DTO
        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(161L);
        itemDTO.setQuantity(1);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        // Perform the request to update the cart
        mockMvc.perform(patch("/api/cart/items/update")
                        .sessionAttr("anonymousCartId", anonymousCartId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully updated quantity"));

        // Simulate the GET request
        MvcResult result = mockMvc.perform(get("/api/cart/get")
                        .sessionAttr("anonymousCartId", anonymousCartId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Extract the response content as a String
        String jsonResponse = result.getResponse().getContentAsString();

        // Convert the JSON response to CartDTO
        ObjectMapper objectMapper = new ObjectMapper();
        CartDTO cartDTO = objectMapper.readValue(jsonResponse, CartDTO.class);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotal(new BigDecimal("1999.98"));
        orderRequest.setPaymentMethod(PaymentMethod.BITCOIN);
        orderRequest.setAnonymousEmail("anonymous@example.com");
        orderRequest.setAnonymousAddress("123 Anonymous St");
        orderRequest.setCartDTO(cartDTO);

        mockMvc.perform(post("/api/order/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(orderRequest))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.grandTotal").value(orderRequest.getTotal()));

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the email was sent
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(1, receivedMessages.length);
        MimeMessage message = receivedMessages[0];

        assertEquals("Order successfully placed", message.getSubject());
        assertTrue(GreenMailUtil.getBody(message).contains("Bitcoin"));
    }

    @Test
    void testCreateOrder_AnonymousUser_Failure_NoAddress() throws Exception {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotal(new BigDecimal("1999.98"));
        orderRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderRequest.setAnonymousEmail("anonymous@example.com");
        orderRequest.setCartDTO(new CartDTO());

        mockMvc.perform(post("/api/order/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(orderRequest))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("No delivery address provided for anonymous order"));
    }

    @Test
    void testCreateOrder_AnonymousUser_Failure_InvalidEmail() throws Exception {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotal(new BigDecimal("1999.98"));
        orderRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderRequest.setAnonymousAddress("Address");
        orderRequest.setAnonymousEmail("anonymous");
        orderRequest.setCartDTO(new CartDTO());

        mockMvc.perform(post("/api/order/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(orderRequest))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("[\"Invalid email address\"]"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testGetOrders_Success() throws Exception {
        // Create and set up the product DTO
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("iPhone 14 Pro");

        // Create and set up the cart item DTO
        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setId(100L);
        itemDTO.setQuantity(4);
        itemDTO.setProduct(productDTO);
        itemDTO.setProductId(1L);

        // Perform the request to update the cart
        mockMvc.perform(patch("/api/cart/items/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(itemDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully updated quantity"));

        // Retrieve the cart and extract CartDTO
        MvcResult mvcResult = mockMvc.perform(get("/api/cart/get")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartItems").isArray())
                .andExpect(jsonPath("$.grandTotal").value(4499.95))
                .andReturn();

        // Extract the response content as a String
        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Convert the JSON response to CartDTO
        ObjectMapper objectMapper = new ObjectMapper();
        CartDTO cartDTO = objectMapper.readValue(jsonResponse, CartDTO.class);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotal(new BigDecimal("4499.95"));
        orderRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderRequest.setAddressId(50L);
        orderRequest.setCartDTO(cartDTO);

        mockMvc.perform(post("/api/order/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(orderRequest))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.grandTotal").value(orderRequest.getTotal()));

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the email was sent
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(1, receivedMessages.length);
        MimeMessage message = receivedMessages[0];

        assertEquals("Order successfully placed", message.getSubject());
        assertTrue(GreenMailUtil.getBody(message).contains("Credit Card"));

        mockMvc.perform(get("/api/order/get/all")
                        .param("p", "0")
                        .param("s", "6"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1))
                .andExpect(jsonPath("$.content[0].grandTotal").value(orderRequest.getTotal()));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    void testGetOrders_Failure() throws Exception {
        mockMvc.perform(get("/api/order/get/all")
                        .param("p", "-1")  // Invalid page number
                        .param("s", "10"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An unexpected error occurred"));
    }
}

