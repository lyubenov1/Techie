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
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productName}/similar")
    public ResponseEntity<List<ProductDTO>> getSimilarProducts(@PathVariable String productName) {
        Optional<Product> productOptional = productService.findByNameIgnoreCase(productName);

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product currentProduct = productOptional.get();
        List<ProductDTO> similarProducts = productService.findSimilarProducts(currentProduct);

        return ResponseEntity.ok(similarProducts);
    }

    @GetMapping("/{productName}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String productName) {
        Optional<Product> productOptional = productService.findByNameIgnoreCase(productName);

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProductDTO productDTO = productService.convertToDTO(productOptional.get());
        return ResponseEntity.ok(productDTO);
    }
}