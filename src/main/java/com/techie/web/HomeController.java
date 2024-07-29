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

    @GetMapping("/moderator")
    public String moderatorPage() {
        return "moderator";
    }

    @GetMapping("/terms-of-use")
    public String termsOfUsePage() {
        return "terms-of-use";
    }

    @GetMapping("/privacy-policy")
    public String privacyPolicyPage() {
        return "privacy-policy";
    }

}