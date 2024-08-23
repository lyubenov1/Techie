package com.techie.web.rest;

import com.icegreen.greenmail.util.*;
import com.techie.config.*;
import com.techie.domain.entities.*;
import com.techie.domain.model.models.*;
import com.techie.repository.*;
import com.techie.service.*;
import com.techie.utils.*;
import jakarta.mail.internet.*;
import static org.hamcrest.Matchers.*;
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
        "spring.cache.type=none"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class AdminRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

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
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testGetUsers_returnAllUsersExcludingBlacklisted() throws Exception {
        mockMvc.perform(get("/api/admin/get")
                        .param("query", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testGetUsers_returnUsersByQueryExcludingBlacklisted() throws Exception {
        mockMvc.perform(get("/api/admin/get")
                        .param("query", "testuser")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testBlacklistUser_Success() throws Exception {
        UserDisplayView user = UserDisplayView.builder()
                .id(4L)
                .username("testNotYetBlacklistedUser")
                .email("testnotblacklisted@example.com")
                .reason("Violation of rules")
                .build();

        mockMvc.perform(post("/api/admin/blacklist/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(user))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("User blacklisted"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testBlacklistUser_UserAlreadyBlacklisted() throws Exception {
        UserDisplayView blacklistedUser = UserDisplayView.builder()
                .id(3L)
                .username("testBlacklistedUser")
                .email("testblacklisted@example.com")
                .reason("Violation of rules")
                .build();

        mockMvc.perform(post("/api/admin/blacklist/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(blacklistedUser))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("User with email: testblacklisted@example.com is already blacklisted"));
    }


    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testBlacklistUser_ModeratorsAndAdminsCanNotBeBlacklisted() throws Exception {
        UserDisplayView blacklistedUser = UserDisplayView.builder()
                .id(2L)
                .username("testUser")
                .email("testuser@example.com")
                .role("Moderator")
                .reason("Violation of rules")
                .build();

        mockMvc.perform(post("/api/admin/blacklist/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(blacklistedUser))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Admins and moderators cannot be blacklisted!"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testGetBlacklistedUsers_ReturnsUsers() throws Exception {
        mockMvc.perform(get("/api/admin/blacklist/get")
                        .param("p", "0")
                        .param("s", "6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1))
                .andExpect(jsonPath("$.content[0].username").value("testBlacklistedUser"))
                .andExpect(jsonPath("$.content[0].email").value("testblacklisted@example.com"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testDiscountProduct_Success() throws Exception {
        ProductAdminView product = ProductAdminView.builder()
                .id(1L)
                .name("iPhone 14 Pro")
                .originalPrice(BigDecimal.valueOf(999.99))
                .discount(BigDecimal.valueOf(10.00))
                .build();

        mockMvc.perform(patch("/api/admin/promotion/patch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(product))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Product successfully discounted"));

        Product updatedProduct = productRepository.findById(1L).orElseThrow();
        assertEquals(899.99, updatedProduct.getDiscountedPrice().doubleValue(), 0.01);

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the email was sent
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(2, receivedMessages.length);
        MimeMessage message = receivedMessages[0];

        assertEquals("Discount on Product: iPhone 14 Pro", message.getSubject());
        assertTrue(GreenMailUtil.getBody(message).contains("iPhone 14 Pro"));
        assertTrue(GreenMailUtil.getBody(message).contains("10%"));
        assertTrue(GreenMailUtil.getBody(message).contains("899,99"));

        // Additional verification that the event is published and handled
        // This is done by checking side effects of the event
        CartItem updatedCartItem = cartItemRepository.findById(100L).orElseThrow();
        assertEquals(2699.97, updatedCartItem.getTotalPrice().doubleValue(), 0.01);
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testRemoveDiscount_IllegalStateException() throws Exception {
        // Ensure the product has no discount
        Long productId = 1L;
        Product product = productRepository.findById(productId).orElseThrow();
        product.setDiscount(null);
        product.setDiscountedPrice(null);
        productRepository.save(product);

        // Perform the request
        mockMvc.perform(delete("/api/admin/promotion/delete")
                        .param("productId", String.valueOf(productId))
                        .with(csrf()))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Product does not have a discount applied."));

        // Verify the product still has no discount
        Product updatedProduct = productRepository.findById(productId).orElseThrow();
        assertNull(updatedProduct.getDiscount());
        assertNull(updatedProduct.getDiscountedPrice());
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testRemoveDiscount_Success() throws Exception {
        mockMvc.perform(delete("/api/admin/promotion/delete")
                        .param("productId", String.valueOf(2L))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Discount successfully removed from product"));

        // Verify the product has no discount
        Product updatedProduct = productRepository.findById(2L).orElseThrow();
        assertNull(updatedProduct.getDiscount());
        assertNull(updatedProduct.getDiscountedPrice());
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testGetPromotionProducts_WithQuery() throws Exception {
        String query = "iPhone";

        mockMvc.perform(get("/api/admin/promotion/get")
                        .param("query", query)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testGetPromotionProducts_WithoutQuery() throws Exception {
        mockMvc.perform(get("/api/admin/promotion/get")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testGetDiscountedProducts_ValidPageAndSize() throws Exception {
        mockMvc.perform(get("/api/admin/discount/get")
                        .param("p", "0")
                        .param("s", "6")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].name").value("iPhone 15 Pro"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"USER", "ADMIN"})
    public void testGetDiscountedProducts_InvalidPageAndSize() throws Exception {
        mockMvc.perform(get("/api/admin/discount/get")
                        .param("p", "-1")
                        .param("s", "-10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Page index must not be less than zero"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"ADMIN"})
    public void testMakeModerator_Success() throws Exception {
        UserDisplayView userView = new UserDisplayView();
        userView.setEmail("testnotblacklisted@example.com");
        userView.setRole("User");

        mockMvc.perform(patch("/api/admin/moderator/patch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(userView))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("User successfully made moderator"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"ADMIN"})
    public void testMakeModerator_UserAlreadyHasAdminRole() throws Exception {
        UserDisplayView userView = new UserDisplayView();
        userView.setEmail("testadmin@example.com"); // testAdmin
        userView.setRole("Admin");

        mockMvc.perform(patch("/api/admin/moderator/patch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(userView))
                        .with(csrf()))
                .andExpect(status().isConflict()) // 409 status
                .andExpect(content().string("User already has role: ADMIN"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"ADMIN"})
    public void testMakeModerator_UserAlreadyHasModeratorRole() throws Exception {
        UserDisplayView userView = new UserDisplayView();
        userView.setEmail("testuser@example.com"); // testUser
        userView.setRole("Moderator");

        mockMvc.perform(patch("/api/admin/moderator/patch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(userView))
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("User already has role: MODERATOR"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"ADMIN"})
    public void testGetModerators_FirstPage() throws Exception {
        mockMvc.perform(get("/api/admin/moderator/get")
                        .param("p", "0")
                        .param("s", "6")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].email").value("testuser@example.com"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"ADMIN"})
    public void testRemoveModerator_Success() throws Exception {
        mockMvc.perform(delete("/api/admin/moderator/remove")
                        .param("userId", "2")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Moderator role removed successfully"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"ADMIN"})
    public void testRemoveModerator_UserNotModerator() throws Exception {
        mockMvc.perform(delete("/api/admin/moderator/remove")
                        .param("userId", "4")
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("User with ID 4 does not have moderator role"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com", roles = {"ADMIN"})
    public void testRemoveModerator_UserNotFound() throws Exception {
        mockMvc.perform(delete("/api/admin/moderator/remove")
                        .param("userId", "999")
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User with ID 999 not found"));
    }

}

