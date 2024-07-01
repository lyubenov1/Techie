package com.techie.domain.model;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResponse {
    private List<ProductDTO> matchedProducts;
    private List<String> searchSuggestions;
}