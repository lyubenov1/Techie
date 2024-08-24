package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.product.*;
import com.techie.exceptions.wishlist.*;
import com.techie.service.*;
import org.slf4j.*;
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
    private final Logger logger = LoggerFactory.getLogger(WishlistRestController.class);

    @Autowired
    public WishlistRestController(WishlistService wishlistService, UserService userService) {
        this.wishlistService = wishlistService;
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<WishlistDTO>> getWishlists(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            List<WishlistDTO> wishlists = wishlistService.getAndConvertWishlists(userDetails.getUsername());
            return ResponseEntity.ok(wishlists);
        } catch (Exception e) {
            logger.error("Error fetching wishlists for user {}: {}", userDetails.getUsername(), e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PatchMapping("/add/{wishlistId}/{productId}")
    public ResponseEntity<String> addToWishlist(@PathVariable Long wishlistId, @PathVariable Long productId,
                                                @AuthenticationPrincipal UserDetails userDetails)
                                                  throws WishlistNotFoundException, ProductNotFoundException, ProductAlreadyInWishlistException {
        try {
            UserEntity user = userService.findByUsername(userDetails.getUsername());
            wishlistService.addProductToWishlist(user, wishlistId, productId);
            return ResponseEntity.ok().body("Product successfully added to wishlist");

        } catch (ProductNotFoundException | WishlistNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ProductAlreadyInWishlistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());  // 409 status code
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @DeleteMapping("/remove/{wishlistId}/{productId}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable Long wishlistId, @PathVariable Long productId,
                                                     @AuthenticationPrincipal UserDetails userDetails)
                                                       throws WishlistNotFoundException, ProductNotFoundException {
        try {
            UserEntity user = userService.findByUsername(userDetails.getUsername());
            wishlistService.removeProductFromWishlist(user, wishlistId, productId);
            return ResponseEntity.ok("Product successfully removed from wishlist");
        } catch (WishlistNotFoundException | ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @DeleteMapping("/removeAll/{wishlistId}")
    public ResponseEntity<String> removeAllFromWishlist(@PathVariable Long wishlistId,
                                                        @AuthenticationPrincipal UserDetails userDetails) {
        try {
            UserEntity user = userService.findByUsername(userDetails.getUsername());
            wishlistService.removeAllProductsFromWishlist(user, wishlistId);
            return ResponseEntity.ok("All products successfully removed from wishlist");
        } catch (WishlistNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}