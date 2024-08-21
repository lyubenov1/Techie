package com.techie.web.rest;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.techie.config.*;
import com.techie.domain.model.DTOs.*;
import com.techie.service.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.security.test.context.support.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import org.springframework.test.context.*;
import org.springframework.test.context.jdbc.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.cache.type=none",
        "spring.main.allow-bean-definition-overriding=true"
})
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class AddressControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @MockBean
    private RoleAdder roleAdder;

    private static Long testAddressId;

    @BeforeEach
    void setUp() throws Exception {
        // Fetch the addresses and store the first address ID before each test
        MvcResult result = mockMvc.perform(get("/api/address/get"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        List<AddressDTO> addresses = new ObjectMapper().readValue(content, new TypeReference<>() {});
        assertFalse(addresses.isEmpty());

        testAddressId = addresses.getFirst().getId();
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    void testCreateAddress() throws Exception {
        AddressDTO newAddressDTO = AddressDTO.builder()
                .name("Example Address")
                .addressLine1("101 Maple Ave")
                .city("UserTown")
                .country("USA")
                .zipcode("11111")
                .build();

        mockMvc.perform(post("/api/address/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newAddressDTO))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Example Address"))
                .andExpect(jsonPath("$.city").value("UserTown"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    void testGetAddresses() throws Exception {
        mockMvc.perform(get("/api/address/get"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn();
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    public void testEditAddress() throws Exception {
        AddressDTO updatedAddressDTO = AddressDTO.builder()
                .id(testAddressId)
                .name("Home Updated")
                .addressLine1("123 Admin St Updated")
                .addressLine2("Apt 100")
                .city("Admin City Updated")
                .country("Admin Country")
                .zipcode("54321")
                .build();

        mockMvc.perform(patch("/api/address/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updatedAddressDTO))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Address successfully updated!"));
    }

    @Test
    @WithMockUser(username = "testadmin@example.com")
    public void testDeleteAddress() throws Exception {
        mockMvc.perform(delete("/api/address/delete/" + testAddressId)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Address successfully deleted!"));
    }

    // Utility method to convert an object to a JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
