package com.techie.web.rest;

import com.techie.config.*;
import com.techie.domain.model.models.*;
import com.techie.service.*;
import com.techie.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.*;
import org.springframework.test.context.jdbc.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.*;
import java.util.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Import({TestConfig.class})
@TestPropertySource(properties = {
        "spring.cache.type=none",
        "spring.main.allow-bean-definition-overriding=true"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class AdminRestControllerIntegrationTest { // This test class passes on its own, but doesn't when ran along with all tests

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdminService adminService;

    @MockBean
    private RoleAdder roleAdder;

    @Test
    @WithMockUser(username = "testadmin@example.com")
    public void testGetUsers_returnAllUsersExcludingBlacklisted() throws Exception {
        mockMvc.perform(get("/api/admin/get")
                        .param("query", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    public void testGetUsers_returnUsersByQueryExcludingBlacklisted() throws Exception {
        mockMvc.perform(get("/api/admin/get")
                        .param("query", "testuser"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    public void testBlacklistUser_Success() throws Exception {
        UserDisplayView user = UserDisplayView.builder()
                .id(4L)
                .username("testNotYetBlacklistedUser")
                .email("testnotblacklisted@example.com")
                .reason("Violation of rules")
                .build();

        mockMvc.perform(post("/api/admin/blacklist/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("User blacklisted"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    public void testBlacklistUser_UserAlreadyBlacklisted() throws Exception {
        UserDisplayView blacklistedUser = UserDisplayView.builder()
                .id(3L)
                .username("testBlacklistedUser")
                .email("testblacklisted@example.com")
                .reason("Violation of rules")
                .build();

        mockMvc.perform(post("/api/admin/blacklist/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(blacklistedUser)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("User with email: testblacklisted@example.com is already blacklisted"));
    }


    @Test
    @WithMockUser(username = "testadmin@example.com")
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
                        .content(JsonUtils.asJsonString(blacklistedUser)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Admins and moderators cannot be blacklisted!"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
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
    @WithMockUser(username = "testadmin@example.com")
    public void testDiscountProducts_Success() throws Exception {
        ProductAdminView product = ProductAdminView.builder()
                .id(1L)
                .name("iPhone 14 Pro")
                .originalPrice(BigDecimal.valueOf(999.99))
                .imageUrls(List.of("https://example.com/image1.jpg"))
                .discount(BigDecimal.valueOf(10.00))
                .build();

        mockMvc.perform(patch("/api/admin/promotion/patch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(product)))
                .andExpect(status().isOk())
                .andExpect(content().string("Product successfully discounted"));
    }
}
