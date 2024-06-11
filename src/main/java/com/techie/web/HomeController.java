package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    private final CategoryService categoryService;

    @Autowired
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

       CategoryDTO categoryDTO = categoryService.convertToDTO(categoryOptional.get());
        model.addAttribute("category", categoryDTO);

        return "products";
    }

}

