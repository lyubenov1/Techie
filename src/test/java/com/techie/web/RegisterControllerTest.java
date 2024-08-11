package com.techie.web;

import com.techie.domain.model.models.*;
import com.techie.service.*;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.context.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.servlet.mvc.support.*;

import java.util.function.*;

class RegisterControllerTest {

    private RegisterController registerController;

    @Mock
    private RegisterService registerService;

    @Mock
    private SecurityContextRepository securityContextRepository;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        registerController = new RegisterController(registerService, securityContextRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
        SecurityContextHolder.clearContext(); // Ensure the SecurityContextHolder is reset after each test
    }

    // Helper method to create a RegisterModel
    private RegisterModel createRegisterModel() {
        return new RegisterModel();
    }

    @Test
    void getRegister_WhenModelDoesNotContainRegisterModel_AddsNewRegisterModel() {
        when(model.containsAttribute("registerModel")).thenReturn(false);

        String viewName = registerController.getRegister(model);

        assertEquals("register", viewName);
        verify(model).addAttribute(eq("registerModel"), any(RegisterModel.class));
    }

    @Test
    void getRegister_WhenModelContainsRegisterModel_DoesNotAddNewRegisterModel() {
        when(model.containsAttribute("registerModel")).thenReturn(true);

        String viewName = registerController.getRegister(model);

        assertEquals("register", viewName);
        verify(model, never()).addAttribute(eq("registerModel"), any(RegisterModel.class));
    }

    @Test
    void initForm_ShouldReturnNewRegisterModel() {
        RegisterModel result = registerController.initForm();

        assertEquals(RegisterModel.class, result.getClass());
    }

    @Test
    void postRegister_WhenBindingHasErrors_ShouldRedirectToRegister() {
        RegisterModel registerModel = createRegisterModel();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Ensure that addFlashAttribute returns the mock itself
        when(redirectAttributes.addFlashAttribute(anyString(), any())).thenReturn(redirectAttributes);

        String viewName = registerController.postRegister(registerModel, bindingResult, redirectAttributes, request, response);

        assertEquals("redirect:/register", viewName);
        verify(redirectAttributes).addFlashAttribute("registerModel", registerModel);
        verify(redirectAttributes).addFlashAttribute(startsWith("org.springframework.validation.BindingResult."), eq(bindingResult));
    }

    @Test
    void postRegister_WhenSuccessfulRegistration_ShouldRedirectToHome() {
        RegisterModel registerModel = createRegisterModel();
        when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = registerController.postRegister(registerModel, bindingResult, redirectAttributes, request, response);

        assertEquals("redirect:/", viewName);
        verify(registerService).registerUser(eq(registerModel), any());
        verify(redirectAttributes).addFlashAttribute("messageSuccess", "Registration successful!");
    }

    @Test
    void postRegister_WhenSuccessfulRegistration_ShouldSetSecurityContext() {
        RegisterModel registerModel = createRegisterModel();
        when(bindingResult.hasErrors()).thenReturn(false);
        SecurityContextHolderStrategy strategy = mock(SecurityContextHolderStrategy.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(strategy.createEmptyContext()).thenReturn(securityContext);

        // Set the mocked strategy
        SecurityContextHolder.setContextHolderStrategy(strategy);

        // Use this typed ArgumentCaptor
        @SuppressWarnings("unchecked")
        ArgumentCaptor<Consumer<Authentication>> authConsumerCaptor = ArgumentCaptor.forClass((Class<Consumer<Authentication>>) (Class<?>) Consumer.class);

        String viewName = registerController.postRegister(registerModel, bindingResult, redirectAttributes, request, response);
        assertEquals("redirect:/", viewName);
        verify(registerService).registerUser(eq(registerModel), authConsumerCaptor.capture());

        // Execute the captured lambda with a mock Authentication
        Authentication mockAuth = mock(Authentication.class);
        authConsumerCaptor.getValue().accept(mockAuth);

        // Now verify the interactions
        verify(strategy).createEmptyContext();
        verify(securityContext).setAuthentication(mockAuth);
        verify(strategy).setContext(securityContext);
        verify(securityContextRepository).saveContext(securityContext, request, response);
        verify(redirectAttributes).addFlashAttribute("messageSuccess", "Registration successful!");
    }
}
