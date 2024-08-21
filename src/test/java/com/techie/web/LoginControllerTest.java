package com.techie.web;

import jakarta.servlet.http.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.web.servlet.mvc.support.*;

public class LoginControllerTest {

    private LoginController loginController;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        loginController = new LoginController();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void login_ShouldReturnLoginView() {
        // Act
        String viewName = loginController.login();

        // Assert
        assertEquals("login", viewName);
    }

    @Test
    void forgotPasswordPage_ShouldReturnForgotPasswordView() {
        // Act
        String viewName = loginController.forgotPasswordPage();

        // Assert
        assertEquals("forgot-password", viewName);
    }

    @Test
    void onFailedLogin_ShouldRedirectToLoginAndSetAttributes() {
        // Arrange
        String email = "test@example.com";
        when(request.getSession()).thenReturn(session);

        // Act
        String viewName = loginController.onFailedLogin(email, redirectAttributes, request);

        // Assert
        assertEquals("redirect:/login", viewName);

        // Verify that the redirect attributes were set correctly
        verify(redirectAttributes).addFlashAttribute("email", email);
        verify(redirectAttributes).addFlashAttribute("bad_credentials", true);

        // Verify that the session attribute was set correctly
        verify(session).setAttribute("failedLoginAttempt", true);
    }
}
