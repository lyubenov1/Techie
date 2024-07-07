package com.techie.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccessController {

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "error-pages/unauthorized";
    }
}