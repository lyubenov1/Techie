package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.exceptions.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.util.*;

import java.lang.reflect.*;
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
        CategoryDTO dto = mapCategoryToDTO(category);
        dto.setProducts(fetchProductsForCategory(category));
        dto.setChildren(fetchChildCategoryDTOs(category));
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

    public List<ProductDTO> getFilteredProducts(String categoryName, Map<String, List<String>> filters) {
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            List<ProductDTO> products = fetchProductsForCategory(category);
            applyFilters(products, filters);
            return products;
        } else {
            throw new CategoryNotFoundException("Category with name " + categoryName + " not found");
        }
    }

    private void applyFilters(List<ProductDTO> products, Map<String, List<String>> filters) {
        for (String key : filters.keySet()) {
            products.removeIf(product -> !filterMatches(product, key, filters.get(key)));
        }
    }

    private boolean filterMatches(ProductDTO product, String key, List<String> values) {
        Class<? extends ProductDTO> productClass = product.getClass();
        if (keyExistsInDTO(productClass, key)) {
            String productValue = getValueFromDTO(product, key);
            for (String filterValue : values) {
                if (filterValue.equalsIgnoreCase(productValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean keyExistsInDTO(Class<? extends ProductDTO> dtoClass, String key) {
        // First, check in the subclass (productClass)
        try {
            dtoClass.getDeclaredField(key);
            return true;
        } catch (NoSuchFieldException e) {
            // If not found in the subclass, check in the superclass (ProductDTO.class)
            try {
                ProductDTO.class.getDeclaredField(key);
                return true;
            } catch (NoSuchFieldException ex) {
                return false;
            }
        }
    }

    private String getValueFromDTO(ProductDTO product, String key) {
        // Attempt to get the value from the subclass (product.getClass())
        try {
            Field field = product.getClass().getDeclaredField(key);
            field.setAccessible(true);
            Object value = field.get(product);
            return value != null ? value.toString() : null;
        } catch (Exception e) {
            // If not found in subclass, attempt to get it from the superclass (ProductDTO.class)
            try {
                Field field = ProductDTO.class.getDeclaredField(key);
                field.setAccessible(true);
                Object value = field.get(product);
                return value != null ? value.toString() : null;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }


    private CategoryDTO mapCategoryToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setImageUrl(category.getImageUrl());
        dto.setUrl("/products/" + encodeCategoryName(category.getName()));
        return dto;
    }

    private List<ProductDTO> fetchProductsForCategory(Category category) {
        List<ProductDTO> products = new ArrayList<>();
        if (category.getChildren() != null && !category.getChildren().isEmpty()) {
            for (Category childCategory : category.getChildren()) {
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