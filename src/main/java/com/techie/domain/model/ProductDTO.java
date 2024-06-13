package com.techie.domain.model;

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
    private String description;
    private Double averageRating;
    private List<CommentDTO> comments;

}