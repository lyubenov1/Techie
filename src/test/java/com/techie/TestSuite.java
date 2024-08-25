package com.techie;

import com.techie.service.*;
import com.techie.web.*;
import com.techie.web.advice.*;
import com.techie.web.rest.*;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({
        OrderControllerIntegrationTest.class,
        CartControllerIntegrationTest.class,
        AdminRestControllerIntegrationTest.class,
        ReviewControllerIntegrationTest.class,
        AddressControllerIntegrationTest.class,
        SettingsControllerIntegrationTest.class,
        PasswordResetControllerIntegrationTest.class,
        WishlistRestControllerIntegrationTest.class,
        GlobalAdviceTest.class,
        RegisterServiceTest.class,
        UserServiceTest.class,
        AccessControllerTest.class,
        AdminControllerTest.class,
        EmailLinkControllerTest.class,
        HomeControllerTest.class,
        LoginControllerTest.class,
        OrderViewControllerTest.class,
        ProductControllerTest.class,
        RegisterControllerTest.class,
        UserControllerTest.class,
        WishlistControllerTest.class,
})
public class TestSuite {  // Run this test suite to run all tests altogether
}