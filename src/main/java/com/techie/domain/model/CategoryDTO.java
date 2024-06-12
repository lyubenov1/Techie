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
    private String url;

    public CategoryDTO(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.url = "";
    }

}