package com.techie.web.rest;

import com.techie.domain.model.DTOs.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistRestController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistRestController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/get")
    public List<WishlistDTO> getWishlists(@AuthenticationPrincipal UserDetails userDetails) {
        return wishlistService.getAndConvertWishlists(userDetails.getUsername());
    }

}