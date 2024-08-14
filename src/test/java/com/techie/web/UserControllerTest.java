package com.techie.web;

import jakarta.servlet.http.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.ui.*;

class UserControllerTest {

    @Mock
    private Model model;

    @Mock
    private HttpSession session;

    @InjectMocks
    private UserController userController;

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
    void getUserProfile_ShouldReturnProfileView_WhenLoginMessageExists() {
        // Arrange
        when(session.getAttribute("loginMessage")).thenReturn("Welcome back!");

        // Act
        String viewName = userController.getUserProfile(model, session);

        // Assert
        assertEquals("profile", viewName);
        verify(model).addAttribute("loginMessage", "Welcome back!");
        verify(session).removeAttribute("loginMessage");
    }

    @Test
    void getUserProfile_ShouldReturnProfileView_WhenNoLoginMessageExists() {
        // Arrange
        when(session.getAttribute("loginMessage")).thenReturn(null);

        // Act
        String viewName = userController.getUserProfile(model, session);

        // Assert
        assertEquals("profile", viewName);
        verify(model, never()).addAttribute(eq("loginMessage"), any());
        verify(session, never()).removeAttribute("loginMessage");
    }

    @Test
    void getUserSettings_ShouldReturnSettingsView() {
        // Act
        String viewName = userController.getUserSettings(model);

        // Assert
        assertEquals("settings", viewName);
        verify(model).addAttribute("activeMenuItem", "settings");
    }

    @Test
    void getUserCart_ShouldReturnCartView() {
        // Act
        String viewName = userController.getUserCart(model);

        // Assert
        assertEquals("loggedUser-cart", viewName);
        verify(model).addAttribute("activeMenuItem", "cart");
    }

    @Test
    void getUserWishlist_ShouldReturnWishlistView() {
        // Act
        String viewName = userController.getUserWishlist(model);

        // Assert
        assertEquals("wishlist", viewName);
        verify(model).addAttribute("activeMenuItem", "wishlist");
    }

    @Test
    void getUserAddresses_ShouldReturnAddressesView() {
        // Act
        String viewName = userController.getUserAddresses(model);

        // Assert
        assertEquals("addresses", viewName);
        verify(model).addAttribute("activeMenuItem", "addresses");
    }

    @Test
    void getUserOrderHistory_ShouldReturnOrderHistoryView() {
        // Act
        String viewName = userController.getUserOrderHistory(model);

        // Assert
        assertEquals("order-history", viewName);
        verify(model).addAttribute("activeMenuItem", "order-history");
    }
}
