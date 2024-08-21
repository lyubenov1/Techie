package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.exceptions.wishlist.*;
import com.techie.service.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.servlet.mvc.support.*;

public class WishlistControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private WishlistService wishlistService;

    @Mock
    private UserDetails userDetails;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private WishlistController wishlistController;

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
    void createWishlist_ShouldRedirectWithSuccessMessage() throws InvalidWishlistNameException, DuplicateWishlistException {
        // Arrange
        String wishlistName = "My Wishlist";
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doNothing().when(wishlistService).createWishlist(user, wishlistName);

        // Act
        String viewName = wishlistController.createWishlist(userDetails, wishlistName, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).createWishlist(user, wishlistName);
        verify(redirectAttributes).addFlashAttribute("successMessage", "Wishlist created successfully!");
    }

    @Test
    void createWishlist_ShouldRedirectWithErrorMessage_WhenInvalidWishlistNameExceptionThrown() throws InvalidWishlistNameException, DuplicateWishlistException {
        // Arrange
        String wishlistName = "Invalid Wishlist";
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doThrow(new InvalidWishlistNameException("Invalid wishlist name")).when(wishlistService).createWishlist(user, wishlistName);

        // Act
        String viewName = wishlistController.createWishlist(userDetails, wishlistName, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).createWishlist(user, wishlistName);
        verify(redirectAttributes).addFlashAttribute("errorMessage", "Invalid wishlist name");
    }

    @Test
    void createWishlist_ShouldRedirectWithErrorMessage_WhenDuplicateWishlistExceptionThrown() throws InvalidWishlistNameException, DuplicateWishlistException {
        // Arrange
        String wishlistName = "Duplicate Wishlist";
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doThrow(new DuplicateWishlistException(wishlistName)).when(wishlistService).createWishlist(user, wishlistName);

        // Act
        String viewName = wishlistController.createWishlist(userDetails, wishlistName, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).createWishlist(user, wishlistName);
        verify(redirectAttributes).addFlashAttribute("errorMessage", "You already have a wishlist named \"" + wishlistName + "\"");
    }

    @Test
    void editWishlistName_ShouldRedirectWithSuccessMessage() throws InvalidWishlistNameException, WishlistNotFoundException {
        // Arrange
        Long wishlistId = 1L;
        String wishlistName = "Updated Wishlist";
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doNothing().when(wishlistService).updateWishlistName(user, wishlistId, wishlistName);

        // Act
        String viewName = wishlistController.editWishlistName(userDetails, wishlistId, wishlistName, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).updateWishlistName(user, wishlistId, wishlistName);
        verify(redirectAttributes).addFlashAttribute("successMessage", "Wishlist name updated successfully!");
    }

    @Test
    void editWishlistName_ShouldRedirectWithErrorMessage_WhenInvalidWishlistNameExceptionThrown() throws InvalidWishlistNameException, WishlistNotFoundException {
        // Arrange
        Long wishlistId = 1L;
        String wishlistName = "Invalid Wishlist";
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doThrow(new InvalidWishlistNameException("Invalid wishlist name")).when(wishlistService).updateWishlistName(user, wishlistId, wishlistName);

        // Act
        String viewName = wishlistController.editWishlistName(userDetails, wishlistId, wishlistName, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).updateWishlistName(user, wishlistId, wishlistName);
        verify(redirectAttributes).addFlashAttribute("errorMessage", "Invalid wishlist name");
    }

    @Test
    void editWishlistName_ShouldRedirectWithErrorMessage_WhenWishlistNotFoundExceptionThrown() throws InvalidWishlistNameException, WishlistNotFoundException {
        // Arrange
        Long wishlistId = 1L;
        String wishlistName = "Any Wishlist";
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doThrow(new WishlistNotFoundException(wishlistId)).when(wishlistService).updateWishlistName(user, wishlistId, wishlistName);

        // Act
        String viewName = wishlistController.editWishlistName(userDetails, wishlistId, wishlistName, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).updateWishlistName(user, wishlistId, wishlistName);
        verify(redirectAttributes).addFlashAttribute("errorMessage", "Wishlist not found with ID: " + wishlistId);
    }

    @Test
    void deleteWishlist_ShouldRedirectWithSuccessMessage() throws WishlistNotFoundException {
        // Arrange
        Long wishlistId = 1L;
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doNothing().when(wishlistService).deleteWishlist(user, wishlistId);

        // Act
        String viewName = wishlistController.deleteWishlist(userDetails, wishlistId, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).deleteWishlist(user, wishlistId);
        verify(redirectAttributes).addFlashAttribute("successMessage", "Wishlist was deleted successfully!");
    }

    @Test
    void deleteWishlist_ShouldRedirectWithErrorMessage_WhenWishlistNotFoundExceptionThrown() throws WishlistNotFoundException {
        // Arrange
        Long wishlistId = 1L;
        UserEntity user = new UserEntity();
        when(userDetails.getUsername()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(user);
        doThrow(new WishlistNotFoundException(wishlistId)).when(wishlistService).deleteWishlist(user, wishlistId);

        // Act
        String viewName = wishlistController.deleteWishlist(userDetails, wishlistId, redirectAttributes);

        // Assert
        assertEquals("redirect:/users/profile/wishlist", viewName);
        verify(wishlistService).deleteWishlist(user, wishlistId);
        verify(redirectAttributes).addFlashAttribute("errorMessage", "Wishlist not found with ID: " + wishlistId);
    }
}
