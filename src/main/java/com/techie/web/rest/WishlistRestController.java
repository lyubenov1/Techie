package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistRestController {

    private final WishlistService wishlistService;
    private final UserService userService;

    @Autowired
    public WishlistRestController(WishlistService wishlistService, UserService userService) {
        this.wishlistService = wishlistService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createWishlist(@AuthenticationPrincipal UserDetails userDetails,
                                            @RequestParam String wishlistName) {
        UserEntity user = userService.findByUsername(userDetails.getUsername());

        try {
            wishlistService.createWishlist(user, wishlistName);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Wishlist created successfully!"));
        } catch (DuplicateWishlistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("errorMessage", e.getMessage()));
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWishlist(@AuthenticationPrincipal UserDetails userDetails,
                                            @PathVariable Long id) {
        UserEntity user = userService.findByUsername(userDetails.getUsername());

        try {
            wishlistService.deleteWishlist(user, id);
            return ResponseEntity.ok().body(Map.of("message", "Wishlist deleted successfully!"));
        } catch (WishlistNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}