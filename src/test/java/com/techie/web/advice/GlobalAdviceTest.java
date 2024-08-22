package com.techie.web.advice;

import com.techie.domain.entities.*;
import com.techie.domain.model.models.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;

import java.util.*;

public class GlobalAdviceTest {

    @Mock
    private UserService userService;

    @Mock
    private ApplicationUserDetailsService userDetailsService;

    @Mock
    private UserDetails userDetails;

    @Mock
    private Model model;

    @InjectMocks
    private GlobalAdvice globalAdvice;

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
    void addUserToModel_UserDetailsNotNull_AddsLoggedUser() {
        // Arrange
        UserEntity user = new UserEntity();
        UserDisplayView userDisplayView = new UserDisplayView();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        when(userService.convertToView(user)).thenReturn(userDisplayView);

        // Act
        globalAdvice.addUserToModel(userDetails, model);

        // Assert
        verify(model).addAttribute("loggedUser", userDisplayView);
    }

    @Test
    void onObjectNotFound_ShouldReturnNotFoundModelAndView() {
        // Arrange
        ObjectNotFoundException exception = new ObjectNotFoundException("Object not found test");
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(new UserEntity());
        when(userService.convertToView(any(UserEntity.class))).thenReturn(new UserDisplayView());

        // Act
        ModelAndView modelAndView = globalAdvice.onObjectNotFound(exception, userDetails);

        // Assert
        assertEquals("error-pages/not-found", modelAndView.getViewName());
        assertEquals(HttpStatus.NOT_FOUND, modelAndView.getStatus());
    }

    @Test
    void handleMaxSizeException_ShouldReturnPayloadTooLargeResponse() {
        // Arrange
        MaxUploadSizeExceededException exception = new MaxUploadSizeExceededException(1024);

        // Act
        ResponseEntity<String> response = globalAdvice.handleMaxSizeException(exception);

        // Assert
        assertEquals(HttpStatus.PAYLOAD_TOO_LARGE, response.getStatusCode());
        assertEquals("File size exceeds the maximum limit.", response.getBody());
    }

    @Test
    void handleValidationExceptions_ShouldReturnBadRequestResponseWithErrors() {
        // Arrange
        org.springframework.core.MethodParameter methodParameter = mock(org.springframework.core.MethodParameter.class);
        BindingResult bindingResult = mock(BindingResult.class);
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(methodParameter, bindingResult);

        FieldError fieldError = new FieldError("object", "field", "Field error message");
        ObjectError objectError = new ObjectError("object", "Global error message");

        when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError));
        when(bindingResult.getGlobalErrors()).thenReturn(List.of(objectError));

        // Act
        ResponseEntity<Map<String, String>> response = globalAdvice.handleValidationExceptions(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(2, response.getBody().size());
        assertEquals("Field error message", response.getBody().get("field"));
        assertEquals("Global error message", response.getBody().get("object"));
    }

    @Test
    void handleGeneralException_ShouldReturnErrorModelAndView() {
        // Arrange
        Exception exception = new Exception("This is a test error");
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(new UserEntity());
        when(userService.convertToView(any(UserEntity.class))).thenReturn(new UserDisplayView());

        // Act
        ModelAndView modelAndView = globalAdvice.handleGeneralException(exception, userDetails);

        // Assert
        assertEquals("error-pages/error", modelAndView.getViewName());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, modelAndView.getStatus());
    }

    @Test
    void addUserToModel_UserDetailsNull_DoesNotAddLoggedUser() {
        // Act
        globalAdvice.addUserToModel(null, model);

        // Assert
        verify(model, never()).addAttribute(eq("loggedUser"), any());
    }

    @Test
    void addUserToModel_UserDetailsUserNotFound_DoesNotThrowException() {
        // Given
        String username = "testUser";
        UserDetails mockUserDetails = new User(username, "password", new ArrayList<>());

        // Ensure the mock returns a user when looked up
        when(userDetailsService.loadUserByUsername(username)).thenReturn(mockUserDetails);

        // When
        assertDoesNotThrow(() -> {
            globalAdvice.addUserToModel(mockUserDetails, model);
        });
    }
}
