package com.techie.domain.model.DTOs;

import lombok.*;

import java.math.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal originalPrice;
    private String categoryName;
    private String brandName;
    private List<String> imageUrls;
    private int stock;
    private String description;
    private Double averageRating;
    private Map<Integer, Integer> ratings;  // Map of individual ratings from 1-5, along with their count
    private Integer reviewCount;
    private String url;
    private BigDecimal discountedPrice;
    private BigDecimal discount;
}