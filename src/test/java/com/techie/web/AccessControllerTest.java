package com.techie.web;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;

public class AccessControllerTest {

    @InjectMocks
    private AccessController accessController;

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
    void unauthorized_ShouldReturnUnauthorizedView() {
        // Act
        String viewName = accessController.unauthorized();

        // Assert
        assertEquals("error-pages/unauthorized", viewName);
    }

    @Test
    void blacklisted_ShouldReturnBlacklistedView() {
        // Act
        String viewName = accessController.blacklisted();

        // Assert
        assertEquals("error-pages/blacklisted", viewName);
    }

    @Test
    void handleTooManyRequestsByEmail_ShouldReturnTooManyRequestsView() {
        // Act
        String viewName = accessController.handleTooManyRequestsByEmail();

        // Assert
        assertEquals("error-pages/too-many-requests", viewName);
    }
}
