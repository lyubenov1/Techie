package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class SearchSuggestionService {
    private final ProductRepository productRepository;

    @Autowired
    public SearchSuggestionService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<String> getSuggestions(String query, int limit) {
        List<Product> products = productRepository.findByNameContainingAndRating(query, PageRequest.of(0, limit));
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }
}
