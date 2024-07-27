package com.techie.web;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String getAdminPage(Model model) {
        model.addAttribute("activeMenuItem", "dashboard");
        return "admin/admin";
    }

    @GetMapping("/promotions")
    public String getPromotionsPage(Model model) {
        model.addAttribute("activeMenuItem", "promotions");
        return "admin/promotions";
    }

    @GetMapping("/blacklist")
    public String getBlacklistPage(Model model) {
        model.addAttribute("activeMenuItem", "blacklist");
        return "admin/blacklist";
    }
}