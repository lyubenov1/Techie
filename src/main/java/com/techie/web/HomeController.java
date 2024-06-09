package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.service.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    private final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/{categoryName}")
    public String categoryPage(@PathVariable String categoryName, Model model) {
        Optional<Category> categoryOptional = categoryService.findByName(categoryName);

        if (categoryOptional.isEmpty()) {
            return "redirect:/";  // Redirect to the home page
        }

        model.addAttribute("category", categoryOptional.get());

        return "products";
    }
}