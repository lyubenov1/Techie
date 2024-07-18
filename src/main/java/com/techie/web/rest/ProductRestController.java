package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/products")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productName}/similar")
    public ResponseEntity<List<ProductDTO>> getSimilarProducts(@PathVariable String productName) {
        Optional<Product> productOptional = productService.findByName(productName);

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product currentProduct = productOptional.get();
        List<ProductDTO> similarProducts = productService.findSimilarProducts(currentProduct);

        return ResponseEntity.ok(similarProducts);
    }
}