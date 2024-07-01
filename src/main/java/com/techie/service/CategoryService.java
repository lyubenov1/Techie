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

    @Cacheable(cacheNames = "categories", key = "'parentCategoryDTOs'")
    public List<CategoryDTO> getParentCategoryDTOs() {
        return getRootCategories().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Cacheable(cacheNames = "categories", key = "#category.id")
    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = mapCategoryToDTO(category);
        dto.setProducts(fetchProductsForCategory(category));
        dto.setChildren(fetchChildCategoryDTOs(category));
        return dto;
    }

    public List<Category> getRootCategories() {
        return categoryRepository.findRootCategories();
    }

    private CategoryDTO mapCategoryToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setImageUrl(category.getImageUrl());
        dto.setUrl("/products/" + encodeCategoryName(category.getName()));
        return dto;
    }

    @Cacheable(cacheNames = "categories", key = "#categoryName")
    public Optional<Category> findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    protected List<ProductDTO> fetchProductsForCategory(Category category) {
        List<ProductDTO> products = new ArrayList<>();
        if (category.getChildren() != null && !category.getChildren().isEmpty()) {              // If the category has subcategories (e.g. Accessories),
            for (Category childCategory : category.getChildren()) {                             // fetch the subcategories' products as well
                products.addAll(productService.getProductsByCategory(childCategory.getId()));
            }

        } else {
            products.addAll(productService.getProductsByCategory(category.getId()));
        }
        return products;
    }

    private List<CategoryDTO> fetchChildCategoryDTOs(Category category) {
        List<CategoryDTO> childrenDTO = new ArrayList<>();
        if (category.getChildren() != null && !category.getChildren().isEmpty()) {
            for (Category childCategory : category.getChildren()) {
                childrenDTO.add(convertToDTO(childCategory));
            }
            return childrenDTO;
        }
        return null;
    }

    private String encodeCategoryName(String categoryName) {
        return UriUtils.encode(categoryName.toLowerCase().replace(" ", "-"), StandardCharsets.UTF_8);
    }

}