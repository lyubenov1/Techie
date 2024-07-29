package com.techie.domain.model;

import lombok.*;

import java.math.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAdminView {  // Product DTO for the admin and moderator pages
    private Long id;
    private String name;
    private BigDecimal originalPrice;
    private List<String> imageUrls;
    private BigDecimal discount;
    private BigDecimal discountedPrice;
}