package com.techie.web;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;

class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

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
    void home_ShouldReturnIndexView() {
        // Act
        String viewName = homeController.home();

        // Assert
        assertEquals("index", viewName);
    }

    @Test
    void getAnonymousUserCart_ShouldReturnAnonymousUserCartView() {
        // Act
        String viewName = homeController.getAnonymousUserCart();

        // Assert
        assertEquals("anonymousUser-cart", viewName);
    }

    @Test
    void aboutUsPage_ShouldReturnAboutUsView() {
        // Act
        String viewName = homeController.aboutUsPage();

        // Assert
        assertEquals("about-us", viewName);
    }

    @Test
    void moderatorPage_ShouldReturnModeratorView() {
        // Act
        String viewName = homeController.moderatorPage();

        // Assert
        assertEquals("moderator", viewName);
    }

    @Test
    void termsOfUsePage_ShouldReturnTermsOfUseView() {
        // Act
        String viewName = homeController.termsOfUsePage();

        // Assert
        assertEquals("terms-of-use", viewName);
    }

    @Test
    void privacyPolicyPage_ShouldReturnPrivacyPolicyView() {
        // Act
        String viewName = homeController.privacyPolicyPage();

        // Assert
        assertEquals("privacy-policy", viewName);
    }
}
