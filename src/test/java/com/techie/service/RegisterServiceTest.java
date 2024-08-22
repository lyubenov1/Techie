package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.models.*;
import com.techie.repository.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;

import java.util.*;
import java.util.function.*;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private WishlistService wishlistService;
    @Mock
    private UserDetailsService userDetailsService;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private MailService mailService;

    @InjectMocks
    private RegisterService registerService;

    private RegisterModel registerModel;
    private RoleEntity userRole;

    @BeforeEach
    void setUp() {
        registerModel = new RegisterModel();
        registerModel.setUsername("testUser");
        registerModel.setFirstName("Test");
        registerModel.setLastName("User");
        registerModel.setEmail("test@example.com");
        registerModel.setPassword("password");
        registerModel.setAddressLine1("123 Test St");
        registerModel.setCity("Test City");
        registerModel.setCountry("Test Country");
        registerModel.setZipCode("12345");

        userRole = new RoleEntity();
        userRole.setRole(UserRoleEnum.USER);
    }

    @Test
    void registerUser_shouldCreateUserAndAddress() {
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(roleRepository.findRoleEntityByRole(UserRoleEnum.USER)).thenReturn(Optional.of(userRole));
        when(userDetailsService.loadUserByUsername(anyString())).thenReturn(mock(UserDetails.class));

        Consumer<Authentication> successfulLoginProcessor = mock(Consumer.class);

        registerService.registerUser(registerModel, successfulLoginProcessor);

        verify(userRepository).save(any(UserEntity.class));
        verify(addressRepository).save(any(Address.class));
        verify(wishlistService).createWishlist(any(UserEntity.class), eq("Main wishlist"));
        verify(successfulLoginProcessor).accept(any(Authentication.class));
        verify(mailService).sendRegistrationEmail(any(UserEntity.class));
    }

    @Test
    void createUserEntity_shouldCreateUserWithUserRole() {
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(roleRepository.findRoleEntityByRole(UserRoleEnum.USER)).thenReturn(Optional.of(userRole));

        UserEntity result = registerService.createUserEntity(registerModel);

        assertEquals("testUser", result.getUsername());
        assertEquals("test@example.com", result.getEmail());
        assertEquals("encodedPassword", result.getPassword());
        assertEquals(List.of(userRole), result.getRoles());
    }

    @Test
    void createAddress_shouldCreateAddressWithUserEntity() {
        UserEntity user = new UserEntity();

        Address result = registerService.createAddress(registerModel, user);

        assertEquals("Address 1", result.getName());
        assertEquals("123 Test St", result.getAddressLine1());
        assertEquals("Test City", result.getCity());
        assertEquals("Test Country", result.getCountry());
        assertEquals("12345", result.getZipcode());
        assertEquals(user, result.getUser());
    }
}