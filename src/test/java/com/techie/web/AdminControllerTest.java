package com.techie.web;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.ui.*;

public class AdminControllerTest {

    @Mock
    private Model model;

    @InjectMocks
    private AdminController adminController;

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
    void getAdminPage_ShouldReturnAdminDashboardView() {
        // Act
        String viewName = adminController.getAdminPage(model);

        // Assert
        assertEquals("admin-dashboard", viewName);
        verify(model).addAttribute("activeMenuItem", "dashboard");
    }

    @Test
    void getPromotionsPage_ShouldReturnAdminPromotionsView() {
        // Act
        String viewName = adminController.getPromotionsPage(model);

        // Assert
        assertEquals("admin-promotions", viewName);
        verify(model).addAttribute("activeMenuItem", "promotions");
    }

    @Test
    void getBlacklistPage_ShouldReturnAdminBlacklistView() {
        // Act
        String viewName = adminController.getBlacklistPage(model);

        // Assert
        assertEquals("admin-blacklist", viewName);
        verify(model).addAttribute("activeMenuItem", "blacklist");
    }
}
