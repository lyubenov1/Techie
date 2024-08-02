package com.techie.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccessController {

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "error-pages/unauthorized";
    }

    @GetMapping("/blacklisted")
    public String blacklisted() {
        return "error-pages/blacklisted";
    }

    @GetMapping("/too-many-requests")
    public String handleTooManyRequestsByEmail() {
        return "error-pages/too-many-requests";
    }
}