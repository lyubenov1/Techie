package com.techie.domain.model;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private String imageUrl;
    private List<CategoryDTO> children;
    private List<ProductDTO> products;
    private String url;

}