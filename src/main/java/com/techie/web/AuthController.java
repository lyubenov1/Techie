package com.techie.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Implement user authentication logic
        return "redirect:/success"; // Or redirect to user profile
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        // Implement user registration logic
        return "redirect:/login"; // Or redirect to success message
    }
}
