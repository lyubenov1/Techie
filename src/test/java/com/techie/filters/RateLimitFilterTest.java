package com.techie.filters;

import com.techie.service.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import org.springframework.test.annotation.*;
import org.springframework.test.annotation.DirtiesContext.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RateLimitFilterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MailService mailService;

    private static final String TEST_EMAIL = "test@example.com";

    @Test
    public void testRateLimitAppliedAfterThreshold() throws Exception {
        // Simulate 4 failed login attempts
        for (int i = 0; i < 4; i++) {
            mockMvc.perform(post("/login")
                            .with(csrf())
                            .param("email", TEST_EMAIL)
                            .sessionAttr("failedLoginAttempt", true))
                    .andExpect(status().isOk()); // Ensure these are allowed
        }

        // On the 5th attempt, rate limit should be applied
        mockMvc.perform(post("/login")
                        .with(csrf())
                        .param("email", TEST_EMAIL)
                        .sessionAttr("failedLoginAttempt", true))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/too-many-requests"));

        // Verify email warning was sent
        verify(mailService, times(1)).sendLoginAttemptWarning(TEST_EMAIL);
    }

    @Test
    public void testRateLimitNotExceeded() throws Exception {
        // Simulate a non-failed login attempt
        mockMvc.perform(post("/login")
                        .param("email", "test@example.com")
                        .sessionAttr("failedLoginAttempt", true)
                        .with(csrf()))
                .andExpect(status().isOk());

        // Ensure no email was sent
        verify(mailService, never()).sendLoginAttemptWarning("test@example.com");
    }
}
