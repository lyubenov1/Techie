package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.util.*;

import java.nio.charset.*;
import java.util.*;
import java.util.stream.*;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    public List<Category> getRootCategories() {
        return categoryRepository.findRootCategories();
    }

    @Cacheable(cacheNames = "categories", key = "#category.id")
    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setImageUrl(category.getImageUrl());

        String encodedName = UriUtils.encode(category.getName().toLowerCase().replace(" ", "-"), StandardCharsets.UTF_8);
        dto.setUrl("/products/" + encodedName);

        if (category.getChildren() != null && !category.getChildren().isEmpty()) {
            List<CategoryDTO> childrenDTO = category.getChildren().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            dto.setChildren(childrenDTO);
        }

        List<ProductDTO> productDTOs = productService.getProductsByCategory(category.getId());
        dto.setProducts(productDTOs);

        return dto;
    }

    @Cacheable(cacheNames = "categories", key = "#categoryName")
    public Optional<Category> findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Cacheable(cacheNames = "categories", key = "'parentCategoryDTOs'")
    public List<CategoryDTO> getParentCategoryDTOs() {
        return this.getRootCategories().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}