package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.domain.model.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/products")
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

    @GetMapping("/promotion/get")
    public ResponseEntity<?> getPromotionProducts(@RequestParam(required = false) String query) {
        try {
            List<ProductAdminView> products = productService.getProductsAdmin(query);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/discount/get")
    public ResponseEntity<?> getDiscountedProducts(@RequestParam(name = "p", required = false) int page,
                                                   @RequestParam(name = "s", required = false) int size) {
        try {
            Page<ProductAdminView> users = productService.getDiscountedProducts(page, size);
            Map<String, Object> response = new HashMap<>();
            response.put("content", users.getContent());
            response.put("number", users.getNumber());
            response.put("totalPages", users.getTotalPages());
            response.put("totalElements", users.getTotalElements());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/promotion/post")
    public ResponseEntity<?> postPromotionProducts(@RequestBody ProductAdminView productAdminView)
                                                     throws ProductNotFoundException, ProductAlreadyDiscountedException {
        try {
            productService.discountProduct(productAdminView);
            return ResponseEntity.ok().body("Product discounted");
        } catch (ProductNotFoundException | ProductAlreadyDiscountedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while discounting the product");
        }
    }

    @DeleteMapping("/promotion/delete")
    public ResponseEntity<String> deletePromotionProducts(@RequestParam Long productId)
                                                           throws ProductNotFoundException {
        try {
            productService.removeDiscount(productId);
            return ResponseEntity.ok("Discount successfully removed from product");
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}