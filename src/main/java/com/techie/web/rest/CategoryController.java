package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.getParentCategoryDTOs();
    }

    @GetMapping("/products/{categoryName}")
    public List<ProductDTO> getFilteredProducts(@PathVariable String categoryName,
                                                @RequestParam(required = false) Map<String, String> filters) {

        return categoryService.getFilteredProducts(categoryName, filters);
    }



}