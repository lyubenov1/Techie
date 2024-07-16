package com.techie.domain.model.DTOs;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishlistDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
