package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistRestController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistRestController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long id) {
        try {
            Wishlist wishlist = wishlistService.findById(id);
            return ResponseEntity.ok(wishlist);
        } catch (WishlistNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
