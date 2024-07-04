package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/search")
public class SearchRestController {

    private final ProductService productService;

    @Autowired
    public SearchRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<SearchResponse> quickSearch(@RequestParam String query) {
        List<ProductDTO> matchedProducts = productService.searchProducts(query, 5);

        SearchResponse response = SearchResponse.builder()
                .matchedProducts(matchedProducts)
                .build();
        return ResponseEntity.ok(response);
    }
}