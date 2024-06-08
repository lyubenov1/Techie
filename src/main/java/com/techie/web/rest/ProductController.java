package com.techie.web.rest;

import com.techie.domain.entities.Category;
import com.techie.domain.entities.Product;
import com.techie.service.CategoryService;
import com.techie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/category/{categoryName}")
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