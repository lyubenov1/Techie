package com.techie.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/forgot-password")
    public String forgotPasswordPage() {
        return "forgot-password";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute("email") String email,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("email", email);
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        return "redirect:/login";
    }
}