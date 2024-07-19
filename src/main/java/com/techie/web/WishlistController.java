package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

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
                                 @RequestParam String wishlistName,
                                 RedirectAttributes redirectAttributes) throws InvalidWishlistNameException, DuplicateWishlistException {
        UserEntity user = userService.findByUsername(userDetails.getUsername());

        try {
            wishlistService.createWishlist(user, wishlistName);
            redirectAttributes.addFlashAttribute("successMessage", "Wishlist created successfully!");
            return "redirect:/users/profile/wishlist";
        } catch (InvalidWishlistNameException | DuplicateWishlistException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/users/profile/wishlist";
        }
    }

    @PatchMapping("/users/profile/wishlist/edit")
    public String editWishlistName(@AuthenticationPrincipal UserDetails userDetails,
                                   @RequestParam Long wishlistId,
                                   @RequestParam String wishlistName,
                                   RedirectAttributes redirectAttributes) throws InvalidWishlistNameException, WishlistNotFoundException {
        UserEntity user = userService.findByUsername(userDetails.getUsername());

        try {
            wishlistService.updateWishlistName(user, wishlistId, wishlistName);
            redirectAttributes.addFlashAttribute("successMessage", "Wishlist name updated successfully!");
        } catch (InvalidWishlistNameException | WishlistNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/users/profile/wishlist";
    }

    @DeleteMapping("/users/profile/wishlist/delete")
    public String deleteWishlist(@AuthenticationPrincipal UserDetails userDetails,
                                            @RequestParam Long wishlistId,
                                            RedirectAttributes redirectAttributes) throws WishlistNotFoundException {
        UserEntity user = userService.findByUsername(userDetails.getUsername());

        try {
            wishlistService.deleteWishlist(user, wishlistId);
            redirectAttributes.addFlashAttribute("successMessage", "Wishlist was deleted successfully!");
        } catch (WishlistNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/users/profile/wishlist";
    }
}
