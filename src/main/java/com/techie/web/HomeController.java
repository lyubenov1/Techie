package com.techie.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/about-us")
    public String aboutUsPage() {
        return "about-us";
    }

    @GetMapping("/terms-of-use")
    public String termsOfUsePage() {
        return "terms-of-use";
    }

}