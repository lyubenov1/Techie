package com.techie.web.rest;


import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.address.*;
import com.techie.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    public AddressController(AddressService addressService, UserService userService) {
        this.addressService = addressService;
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<AddressDTO>> getAddresses(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            List<AddressDTO> addresses = addressService.getAndConvertAddresses(userDetails.getUsername());
            return ResponseEntity.ok(addresses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@AuthenticationPrincipal UserDetails userDetails,
                                           @RequestBody AddressDTO addressDTO) {
        try {
            UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());
            addressService.createAddress(user, addressDTO);
            return ResponseEntity.ok("Address successfully created!");
        } catch (AddressExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (InvalidAddressNameException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> editAddress(@AuthenticationPrincipal UserDetails userDetails,
                                           @RequestBody AddressDTO addressDTO) {
        try {
            UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());
            addressService.editAddress(user, addressDTO);
            return ResponseEntity.ok("Address successfully updated!");
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (AddressExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (InvalidAddressNameException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@AuthenticationPrincipal UserDetails userDetails,
                                                 @PathVariable Long addressId) {
        try {
            UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());
            addressService.deleteAddress(user, addressId);
            return ResponseEntity.ok("Address successfully deleted!");
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
