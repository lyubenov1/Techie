package com.techie.domain.model;

import com.techie.domain.model.DTOs.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResponse {
    private List<ProductDTO> matchedProducts;
}