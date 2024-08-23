package com.techie.web.rest;

import com.icegreen.greenmail.util.*;
import com.techie.config.*;
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
import org.springframework.security.crypto.password.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import org.springframework.test.context.*;
import org.springframework.test.context.jdbc.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "spring.cache.type=none",
        "spring.main.allow-bean-definition-overriding=true"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PasswordResetControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    @Transactional
    void testResetPasswordFlow() throws Exception {  // Test method combining step one and step two of the verification process
        // Step One: Request password reset
        Map<String, String> request = new HashMap<>();
        request.put("email", "testuser@example.com");

        mockMvc.perform(post("/api/password/reset-password/step-one")
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Password reset email sent"));

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the email was sent
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(1, receivedMessages.length);
        MimeMessage message = receivedMessages[0];

        assertEquals("Reset Your Password", message.getSubject());
        String emailContent = GreenMailUtil.getBody(message);

        // Extract the token from the email content
        String resetToken = emailContent.substring(emailContent.indexOf("token=") + 6, emailContent.indexOf("token=") + 42);

        // Step Two: Reset password using the token
        ResetPasswordRequest resetRequest = ResetPasswordRequest.builder()
                .password("testPassword12.")
                .confirmPassword("testPassword12.")
                .token(resetToken)
                .build();

        mockMvc.perform(post("/api/password/reset-password/step-two")
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(resetRequest))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Password successfully reset!"));

        // Wait for async operations to complete
        Thread.sleep(2000);

        // Verify that the confirmation email was sent
        receivedMessages = greenMail.getReceivedMessages();
        assertEquals(2, receivedMessages.length);
        message = receivedMessages[1];

        assertEquals("Password change", message.getSubject());
        assertTrue(GreenMailUtil.getBody(message).contains("Your password has been changed. If it wasn't you, contact us immediately."));
    }

    @Test
    @Transactional
    void testResetPasswordStepOne_Failure_EmailNotProvided() throws Exception {
        Map<String, String> request = new HashMap<>();

        mockMvc.perform(post("/api/password/reset-password/step-one")
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Email is required"));
    }

    @Test
    @Transactional
    void testResetPasswordStepOne_Failure_EmailNotFound() throws Exception {
        Map<String, String> request = new HashMap<>();
        request.put("email", "nonexistent@example.com");

        mockMvc.perform(post("/api/password/reset-password/step-one")
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string(String.format("User with email %s not found!", "nonexistent@example.com")));
    }

    @Test
    @Transactional
    void testResetPasswordStepTwo_Failure_EmailNotFound() throws Exception {
        ResetPasswordRequest request = ResetPasswordRequest.builder()
                .password("testPassword12.")
                .confirmPassword("testPassword12.")
                .token("2cFpO26a4Fss6")  // Invalid token
                .build();

        mockMvc.perform(post("/api/password/reset-password/step-two")
                        .contentType("application/json")
                        .content(JsonUtils.asJsonString(request))
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User with email null not found!"));
    }
}