package com.techie.web;

import jakarta.servlet.http.*;
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
    public String onFailedLogin(@ModelAttribute("email") String email, RedirectAttributes redirectAttributes,
                                HttpServletRequest request) {

        redirectAttributes.addFlashAttribute("email", email);
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        // Set a session attribute to indicate a failed login attempt
        request.getSession().setAttribute("failedLoginAttempt", true);

        return "redirect:/login";
    }
}