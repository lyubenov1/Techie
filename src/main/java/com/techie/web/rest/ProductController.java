package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService,
                             CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String categoryName) {
        Optional<Category> categoryOptional = categoryService.findByName(categoryName);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            List<Product> products = productService.findByCategory(category);
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found
        }
    }
}