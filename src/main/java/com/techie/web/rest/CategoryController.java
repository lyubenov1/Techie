package com.techie.web.rest;

import com.techie.domain.model.DTOs.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
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
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = categoryService.getParentCategoryDTOs();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
