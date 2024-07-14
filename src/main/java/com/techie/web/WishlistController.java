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

    private final WishlistService wishlistService;
    private final UserService userService;

    @Autowired
    public WishlistController(WishlistService wishlistService, UserService userService) {
        this.wishlistService = wishlistService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createWishlist(@AuthenticationPrincipal UserDetails userDetails,
                                 @RequestParam String wishlistName,
                                 RedirectAttributes redirectAttributes) {
        UserEntity user = userService.findByUsername(userDetails.getUsername());
        try {
            wishlistService.createWishlist(user, wishlistName);
            redirectAttributes.addFlashAttribute("successMessage", "Wishlist created successfully!");
        } catch (DuplicateWishlistException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/wishlist";
    }
}
