package com.techie.web;

import com.techie.domain.entities.Category;
import com.techie.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

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

    @GetMapping("/categories/{categoryName}")
    public String categoryPage(@PathVariable String categoryName, Model model) {
        Optional<Category> categoryOptional = categoryService.findByName(categoryName);

        if (categoryOptional.isEmpty()) {
            return "redirect:/";  // Redirect to the home page
        }

        model.addAttribute("category", categoryOptional.get());

        return "products";
    }
}