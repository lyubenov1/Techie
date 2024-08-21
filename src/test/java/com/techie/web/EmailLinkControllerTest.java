package com.techie.web;

import com.techie.service.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.ui.*;
import org.springframework.web.servlet.mvc.support.*;

public class EmailLinkControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private SubscriptionService subscriptionService;

    @Mock
    private SettingsService settingsService;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private Model model;

    @InjectMocks
    private EmailLinkController emailLinkController;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void confirmDelete_ShouldRedirectToHomeWithSuccessMessage() {
        // Arrange
        String token = "valid-token";
        doNothing().when(userService).confirmDelete(token);

        // Act
        String viewName = emailLinkController.confirmDelete(token, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(userService).confirmDelete(token);
        verify(redirectAttributes).addFlashAttribute("messageSuccess", "Account successfully deleted");
    }

    @Test
    void confirmDelete_ShouldRedirectToHomeWithErrorMessage_WhenIllegalArgumentExceptionIsThrown() {
        // Arrange
        String token = "invalid-token";
        doThrow(new IllegalArgumentException("Invalid token")).when(userService).confirmDelete(token);

        // Act
        String viewName = emailLinkController.confirmDelete(token, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(userService).confirmDelete(token);
        verify(redirectAttributes).addFlashAttribute("messageError", "Invalid token");
    }

    @Test
    void confirmDelete_ShouldRedirectToHomeWithErrorMessage_WhenExceptionIsThrown() {
        // Arrange
        String token = "any-token";
        doThrow(new RuntimeException("Unexpected error")).when(userService).confirmDelete(token);

        // Act
        String viewName = emailLinkController.confirmDelete(token, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(userService).confirmDelete(token);
        verify(redirectAttributes).addFlashAttribute("messageError", "An error occurred while processing your request.");
    }

    @Test
    void unsubscribeFromNewsletter_ShouldRedirectToHomeWithSuccessMessage() {
        // Arrange
        String token = "valid-token";
        doNothing().when(subscriptionService).unsubscribe(token);

        // Act
        String viewName = emailLinkController.unsubscribeFromNewsletter(token, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(subscriptionService).unsubscribe(token);
        verify(redirectAttributes).addFlashAttribute("messageSuccess", "Successfully unsubscribed from Newsletter");
    }

    @Test
    void unsubscribeFromNewsletter_ShouldRedirectToHomeWithErrorMessage_WhenUsernameNotFoundExceptionIsThrown() {
        // Arrange
        String token = "invalid-token";
        doThrow(new UsernameNotFoundException("User not found")).when(subscriptionService).unsubscribe(token);

        // Act
        String viewName = emailLinkController.unsubscribeFromNewsletter(token, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(subscriptionService).unsubscribe(token);
        verify(redirectAttributes).addFlashAttribute("messageError", "User not found");
    }

    @Test
    void unsubscribeFromNewsletter_ShouldRedirectToHomeWithErrorMessage_WhenExceptionIsThrown() {
        // Arrange
        String token = "any-token";
        doThrow(new RuntimeException("Unexpected error")).when(subscriptionService).unsubscribe(token);

        // Act
        String viewName = emailLinkController.unsubscribeFromNewsletter(token, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(subscriptionService).unsubscribe(token);
        verify(redirectAttributes).addFlashAttribute("messageError", "An error occurred while processing your request.");
    }

    @Test
    void resetPassword_ShouldReturnResetPasswordView_WhenTokenIsValid() {
        // Arrange
        String token = "valid-token";
        doNothing().when(settingsService).verifyToken(token);

        // Act
        String viewName = emailLinkController.resetPassword(token, model, redirectAttributes);

        // Assert
        assertEquals("reset-password", viewName);
        verify(settingsService).verifyToken(token);
        verify(model).addAttribute("token", token);
    }

    @Test
    void resetPassword_ShouldRedirectToHomeWithErrorMessage_WhenIllegalArgumentExceptionIsThrown() {
        // Arrange
        String token = "invalid-token";
        doThrow(new IllegalArgumentException("Invalid token")).when(settingsService).verifyToken(token);

        // Act
        String viewName = emailLinkController.resetPassword(token, model, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(settingsService).verifyToken(token);
        verify(redirectAttributes).addFlashAttribute("messageError", "Invalid token");
    }

    @Test
    void resetPassword_ShouldRedirectToHomeWithErrorMessage_WhenExceptionIsThrown() {
        // Arrange
        String token = "any-token";
        doThrow(new RuntimeException("Unexpected error")).when(settingsService).verifyToken(token);

        // Act
        String viewName = emailLinkController.resetPassword(token, model, redirectAttributes);

        // Assert
        assertEquals("redirect:/", viewName);
        verify(settingsService).verifyToken(token);
        verify(redirectAttributes).addFlashAttribute("messageError", "An error occurred while processing your request.");
    }
}
