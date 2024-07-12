package com.techie.web;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/profile")
public class UserController {

    @GetMapping
    public String getUserProfile() {
        return "profile";
    }

    @GetMapping("/settings")
    public String getUserSettings(Model model) {
        model.addAttribute("activeMenuItem", "settings");
        return "settings";
    }

    @GetMapping("/cart")
    public String getUserCart(Model model) {
        model.addAttribute("activeMenuItem", "cart");
        return "cart";
    }

    @GetMapping("/wishlist")
    public String getUserWishlist(Model model) {
        model.addAttribute("activeMenuItem", "wishlist");
        return "wishlist";
    }

    @GetMapping("/addresses")
    public String getUserAddresses(Model model) {
        model.addAttribute("activeMenuItem", "addresses");
        return "addresses";
    }

    @GetMapping("/order-history")
    public String getUserOrderHistory(Model model) {
        model.addAttribute("activeMenuItem", "order-history");
        return "order-history";
    }

}