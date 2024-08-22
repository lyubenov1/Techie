package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.models.*;
import com.techie.exceptions.user.*;
import com.techie.repository.*;
import jakarta.servlet.http.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.authentication.logout.*;

import java.time.*;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private TokenService tokenService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private SecurityContextLogoutHandler logoutHandler;

    @InjectMocks
    private UserService userService;

    private UserEntity testUser;
    private RoleEntity testRole;

    @BeforeEach
    void setUp() {
        testUser = new UserEntity();
        testUser.setEmail("test@example.com");
        testRole = new RoleEntity();
        testRole.setRole(UserRoleEnum.USER);
        testUser.setRoles(new ArrayList<>(List.of(testRole)));
        testUser.setCreatedAt(LocalDateTime.now());
    }

    @Test
    void findByUsername_shouldReturnUser() {
        when(userRepository.findByEmailFetchRolesAndWishlists("test@example.com")).thenReturn(Optional.of(testUser));

        UserEntity result = userService.findByUsername("test@example.com");

        assertEquals(testUser, result);
    }

    @Test
    void findByUsername_shouldThrowException_whenUserNotFound() {
        when(userRepository.findByEmailFetchRolesAndWishlists("nonexistent@example.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.findByUsername("nonexistent@example.com"));
    }

    @Test
    void findByUsernameWithRoles_shouldReturnUser() {
        when(userRepository.findByEmailFetchRoles("test@example.com")).thenReturn(Optional.of(testUser));

        UserEntity result = userService.findByUsernameWithRoles("test@example.com");

        assertEquals(testUser, result);
    }

    @Test
    void findByUsernameNoFetches_shouldReturnUser() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(testUser));

        UserEntity result = userService.findByUsernameNoFetches("test@example.com");

        assertEquals(testUser, result);
    }

    @Test
    void existsByUsername_shouldReturnTrue_whenUserExists() {
        when(userRepository.existsByUsername("test@example.com")).thenReturn(true);

        assertTrue(userService.existsByUsername("test@example.com"));
    }

    @Test
    void addRoleToUser_shouldAddRole_whenUserDoesNotHaveRole() throws UserAlreadyHasRoleException {
        RoleEntity adminRole = new RoleEntity();
        adminRole.setRole(UserRoleEnum.ADMIN);

        when(userRepository.findByEmailFetchRoles("test@example.com")).thenReturn(Optional.of(testUser));
        when(roleRepository.findRoleEntityByRole(UserRoleEnum.ADMIN)).thenReturn(Optional.of(adminRole));

        userService.addRoleToUser("test@example.com", UserRoleEnum.ADMIN);

        verify(userRepository).save(testUser);
        assertTrue(testUser.getRoles().contains(adminRole));
    }

    @Test
    void addRoleToUser_shouldThrowException_whenUserAlreadyHasRole() {
        when(userRepository.findByEmailFetchRoles("test@example.com")).thenReturn(Optional.of(testUser));
        when(roleRepository.findRoleEntityByRole(UserRoleEnum.USER)).thenReturn(Optional.of(testRole));

        assertThrows(UserAlreadyHasRoleException.class, () -> userService.addRoleToUser("test@example.com", UserRoleEnum.USER));
    }

    @Test
    void convertToView_shouldReturnUserDisplayView() {
        UserDisplayView view = userService.convertToView(testUser);
        assertNotNull(view);
    }

    @Test
    void updateProfileImage_shouldUpdateUserProfileImage() {
        userService.updateProfileImage(testUser, "https://example.com/image.jpg", "public_id");

        assertEquals("https://example.com/image.jpg", testUser.getProfileImageUrl());
        assertEquals("public_id", testUser.getPublicId());
        verify(userRepository).save(testUser);
    }

    @Test
    void saveUser_shouldSaveUser() {
        userService.saveUser(testUser);

        verify(userRepository).save(testUser);
    }

    @Test
    void confirmDelete_shouldDeleteUserAndLogout() {
        String token = "valid_token";
        String email = "test@example.com";
        when(tokenService.getEmailByToken(token)).thenReturn(email);

        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        // Mock OrderRepository behavior
        when(orderRepository.findAllByUserEmailWithAddresses(email)).thenReturn(new ArrayList<>());

        userService.confirmDelete(token);

        verify(userRepository).deleteByEmail(email);
        verify(tokenService).removeToken(token);
        verify(logoutHandler).logout(request, response, authentication);
    }

    @Test
    void confirmDelete_shouldThrowException_whenTokenInvalid() {
        String token = "invalid_token";
        when(tokenService.getEmailByToken(token)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> userService.confirmDelete(token));
    }

    @Test
    void getSubscribedUsers_shouldReturnListOfSubscribedUsers() {
        List<UserEntity> subscribedUsers = Collections.singletonList(testUser);
        when(userRepository.findSubscribedUsers()).thenReturn(subscribedUsers);

        List<UserEntity> result = userService.getSubscribedUsers();

        assertEquals(subscribedUsers, result);
    }
}