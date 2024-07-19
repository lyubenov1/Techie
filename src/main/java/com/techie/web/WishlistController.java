package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import java.util.*;

@Controller
public class WishlistController {
    private final UserService userService;
    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(UserService userService, WishlistService wishlistService) {
        this.userService = userService;
        this.wishlistService = wishlistService;
    }

    @PostMapping("/users/profile/wishlist/create")
    public String createWishlist(@AuthenticationPrincipal UserDetails userDetails,
                                 @RequestParam String wishlistName, RedirectAttributes redirectAttributes) throws DuplicateWishlistException {
        UserEntity user = userService.findByUsername(userDetails.getUsername());

        try {
            wishlistService.createWishlist(user, wishlistName);
            redirectAttributes.addFlashAttribute("successMessage", "Wishlist created successfully!");
            return "redirect:/users/profile/wishlist";
        } catch (DuplicateWishlistException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/users/profile/wishlist";
        }
    }

    @PatchMapping("/users/profile/wishlist/edit")
    public String editWishlistName(@AuthenticationPrincipal UserDetails userDetails,
                                   @RequestParam Long wishlistId,
                                   @RequestParam String wishlistName,
                                   RedirectAttributes redirectAttributes) {
        UserEntity user = userService.findByUsername(userDetails.getUsername());

        if (wishlistName == null || wishlistName.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "New name cannot be empty");
            return "redirect:/users/profile/wishlist";
        }

        try {
            wishlistService.updateWishlistName(user, wishlistId, wishlistName);
            redirectAttributes.addFlashAttribute("successMessage", "Wishlist name updated successfully!");
        } catch (InvalidWishlistNameException | WishlistNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/users/profile/wishlist";
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
