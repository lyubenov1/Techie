package com.techie.web.rest;

import com.icegreen.greenmail.util.*;
import com.techie.config.*;
import com.techie.domain.entities.*;
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
import org.springframework.mock.web.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.test.context.support.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import org.springframework.test.context.*;
import org.springframework.test.context.jdbc.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.transaction.annotation.*;

import java.nio.file.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.cache.type=none"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class SettingsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

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
    @WithMockUser(username = "testadmin@example.com")
    @Transactional
    void testChangeProfileImage_Success() throws Exception {
        byte[] imageContent = Files.readAllBytes(Paths.get("src/test/resources/test-image.jpg"));
        MockMultipartFile file = new MockMultipartFile(
                "image",
                "test-image.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                imageContent
        );

        // Upload initial image that will be changed later
        UserDetails userDetails = userDetailsService.loadUserByUsername("testadmin@example.com");
        settingsService.changeProfileImage(userDetails, file);

        byte[] imageContent2 = Files.readAllBytes(Paths.get("src/test/resources/test-image2.jpg"));
        MockMultipartFile file2 = new MockMultipartFile(
                "image",
                "test-image2.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                imageContent2
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/settings/profile-image/change")
                        .file(file2)
                        .with(csrf())
                        .with(request -> {
                            request.setMethod("PATCH");
                            return request;
                        }))
                .andExpect(status().isOk())
                .andExpect(content().string("Profile image updated successfully"));
    }


    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangeProfileImage_Failure_EmptyFile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/settings/profile-image/change")
                        .file("image", new byte[0])
                        .with(csrf())
                        .with(request -> {
                            request.setMethod("PATCH");
                            return request;
                        }))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Please select a file to upload"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangeDetails_Success() throws Exception {
        DetailsChangeRequest request = new DetailsChangeRequest();
        request.setUsername("testchange@example.com");
        request.setFirstName("Test");
        request.setLastName("Change");

        mockMvc.perform(patch("/api/settings/details/change")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("You have successfully changed your details!"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangeDetails_NoChangesMade() throws Exception {
        DetailsChangeRequest request = new DetailsChangeRequest();
        request.setUsername("testUser");
        request.setFirstName("Test");
        request.setLastName("User");

        mockMvc.perform(patch("/api/settings/details/change")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("No changes were made"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangeDetails_EmptyRequest() throws Exception {
        DetailsChangeRequest request = new DetailsChangeRequest();

        mockMvc.perform(patch("/api/settings/details/change")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("At least one field must be provided for update"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangeDetails_Failure_UsernameAlreadyTaken() throws Exception {
        DetailsChangeRequest request = new DetailsChangeRequest();
        request.setUsername("testAdmin");

        mockMvc.perform(patch("/api/settings/details/change")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("Username is already taken"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangePassword_Success() throws Exception {
        String encodedPassword = passwordEncoder.encode("testPassword1.");
        UserEntity user = userService.findByUsernameNoFetches("testuser@example.com");
        user.setPassword(encodedPassword);
        userService.saveUser(user);

        ChangePasswordRequest request = ChangePasswordRequest.builder()
                .oldPassword("testPassword1.")
                .password("testPassword2.")
                .confirmPassword("testPassword2.")
                .build();

        mockMvc.perform(patch("/api/settings/password/change")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Password changed successfully"));

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the email was sent
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(1, receivedMessages.length);
        MimeMessage message = receivedMessages[0];

        assertEquals("Password change", message.getSubject());
        assertTrue(GreenMailUtil.getBody(message).contains("Your password has been changed. If it wasn't you, contact us immediately."));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangePassword_IncorrectPassword() throws Exception {
        String encodedPassword = passwordEncoder.encode("testPassword1.");
        UserEntity user = userService.findByUsernameNoFetches("testuser@example.com");
        user.setPassword(encodedPassword);
        userService.saveUser(user);

        ChangePasswordRequest request = ChangePasswordRequest.builder()
                .oldPassword("testPassword99.")
                .password("testPassword2.")
                .confirmPassword("testPassword2.")
                .build();

        mockMvc.perform(patch("/api/settings/password/change")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Password is incorrect"));
    }

    @Test
    @Transactional
    void testChangeSubscriptionStatusFooter_Success() throws Exception {
        SubscriptionUpdateRequest request = new SubscriptionUpdateRequest();
        request.setEmail("testuser@example.com");
        request.setStatus(true);

        mockMvc.perform(patch("/api/settings/subscription/change/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("You have successfully subscribed to our newsletter!"));
    }

    @Test
    @Transactional
    void testChangeSubscriptionStatusFooter_UserAlreadySubscribed() throws Exception {
        SubscriptionUpdateRequest request = new SubscriptionUpdateRequest();
        request.setEmail("testadmin@example.com");
        request.setStatus(true);

        mockMvc.perform(patch("/api/settings/subscription/change/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isConflict())
                .andExpect(content().string("User is already subscribed."));
    }

    @Test
    @Transactional
    void testChangeSubscriptionStatusFooter_UserNotFound() throws Exception {
        SubscriptionUpdateRequest request = new SubscriptionUpdateRequest();
        request.setEmail("nonexistingemail@example.com");
        request.setStatus(true);

        mockMvc.perform(patch("/api/settings/subscription/change/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string(String.format("User with email %s not found!", "nonexistingemail@example.com")));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testChangeSubscriptionStatusSettings_Subscribe_Success() throws Exception {
        SubscriptionUpdateRequest request = new SubscriptionUpdateRequest();
        request.setStatus(true);

        mockMvc.perform(patch("/api/settings/subscription/change/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Subscription status updated successfully."));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    @Transactional
    void testChangeSubscriptionStatusSettings_Unsubscribe_Success() throws Exception {
        SubscriptionUpdateRequest request = new SubscriptionUpdateRequest();
        request.setStatus(false);

        mockMvc.perform(patch("/api/settings/subscription/change/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Subscription status updated successfully."));
    }

    @Test
    @WithMockUser(username = "testuser@example.com")
    @Transactional
    void testDeleteAccount_Success() throws Exception {
        mockMvc.perform(delete("/api/settings/account/delete")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Confirmation email sent."));

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the email was sent
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(1, receivedMessages.length);
        MimeMessage message = receivedMessages[0];

        assertEquals("Confirm your account deletion", message.getSubject());
        assertTrue(GreenMailUtil.getBody(message).contains("http://localhost:8080/email/confirm-delete?token="));
    }
}