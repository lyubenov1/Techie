package com.techie.web.rest;

import com.techie.config.*;
import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.domain.model.models.*;
import com.techie.exceptions.address.*;
import com.techie.service.*;
import org.junit.jupiter.api.*;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

@CustomWebMvcTest(AddressController.class)
@Import({TestSecurityConfig.class})
@TestPropertySource(properties = {
        "spring.cache.type=none",
        "spring.main.allow-bean-definition-overriding=true"
})
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    @MockBean
    private UserService userService;

    private UserEntity testUser;
    private AddressDTO testAddressDTO;
    private UserDisplayView userDisplayView;

    @BeforeEach
    void setUp() {
        UserEntity user = new UserEntity();
        user.setUsername("testUser");
        user.setProfileImageUrl("https://example.com/image.jpg");
        UserDisplayView userView = new UserDisplayView();
        userView.setUsername("testUser");
        userView.setProfileImage("https://example.com/image.jpg");

        Mockito.when(userService.findByUsername("testUser")).thenReturn(user);
        Mockito.when(userService.convertToView(user)).thenReturn(userView);

        testAddressDTO = new AddressDTO();
        testAddressDTO.setId(1L);
        testAddressDTO.setName("Test Address");
    }

    @Test
    @WithMockUser(username = "testUser")
    void getAddresses_success() throws Exception {
        List<AddressDTO> addresses = List.of(testAddressDTO);
        Mockito.when(addressService.getAndConvertAddresses(anyString())).thenReturn(addresses);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/address/get"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(testAddressDTO.getId()))
                .andExpect(jsonPath("$[0].name").value(testAddressDTO.getName()));
    }

    @Test
    @WithMockUser(username = "testUser")
    void createAddress_success() throws Exception {
        Mockito.when(addressService.createAddress(any(UserEntity.class), any(AddressDTO.class)))
                .thenReturn(testAddressDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/address/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Address\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(testAddressDTO.getId()))
                .andExpect(jsonPath("$.name").value(testAddressDTO.getName()))
                .andExpect(header().string("Location", "/api/address/create/1"));
    }

    @Test
    @WithMockUser(username = "testUser")
    void createAddress_conflict() throws Exception {
        Mockito.when(addressService.createAddress(any(UserEntity.class), any(AddressDTO.class)))
                .thenThrow(new AddressExistsException("Test Address"));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/address/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Address\"}"))
                .andExpect(status().isConflict())
                .andExpect(content().string("Address with name 'Test Address' already exists"));
    }

    @Test
    @WithMockUser(username = "testUser")
    void editAddress_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/address/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Updated Address\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Address successfully updated!"));
    }

    @Test
    @WithMockUser(username = "testUser")
    void editAddress_notFound() throws Exception {
        Mockito.doThrow(new AddressNotFoundException(1L)).when(addressService)
                .editAddress(any(UserEntity.class), any(AddressDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/address/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Updated Address\"}"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Address with id '1' not found"));
    }

    @Test
    @WithMockUser(username = "testUser")
    void deleteAddress_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/address/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Address successfully deleted!"));
    }

    @Test
    @WithMockUser(username = "testUser")
    void deleteAddress_notFound() throws Exception {
        Mockito.doThrow(new AddressNotFoundException(1L)).when(addressService)
                .deleteAddress(any(UserEntity.class), anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/address/delete/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Address with id '1' not found"));
    }
}
