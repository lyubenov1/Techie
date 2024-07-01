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
    private final SearchSuggestionService searchSuggestionService;

    @Autowired
    public SearchRestController(ProductService productService, SearchSuggestionService searchSuggestionService) {
        this.productService = productService;
        this.searchSuggestionService = searchSuggestionService;
    }

    @GetMapping
    public ResponseEntity<SearchResponse> quickSearch(@RequestParam String query) {
        List<ProductDTO> matchedProducts = productService.searchProducts(query, 3);
        List<String> searchSuggestions = searchSuggestionService.getSuggestions(query, 3);

        SearchResponse response = new SearchResponse(matchedProducts, searchSuggestions);
        return ResponseEntity.ok(response);
    }
}