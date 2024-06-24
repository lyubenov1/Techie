package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.exceptions.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

@Service
public class ProductFilterService {
    private final CategoryService categoryService;
    private final Logger logger = LoggerFactory.getLogger(ProductFilterService.class);

    @Autowired
    public ProductFilterService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<ProductDTO> getFilteredProducts(String categoryName, Map<String, String> filters) {
        Optional<Category> categoryOptional = categoryService.findByName(categoryName);
        Map<String, List<String>> convertedFilters = convertFilters(filters);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            List<ProductDTO> products = categoryService.fetchProductsForCategory(category);
            applyFilters(products, convertedFilters);

            //logger.info("Filtered products size after applying filters: {}", filteredProducts.size());
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
            return values.stream().anyMatch(filterValue -> filterValue.equalsIgnoreCase(productValue));
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

    private Map<String, List<String>> convertFilters(Map<String, String> filters) {
        Map<String, List<String>> convertedFilters = new LinkedHashMap<>();

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            List<String> values = Arrays.stream(entry.getValue().split(","))
                    .collect(Collectors.toList());

            convertedFilters.put(key, values);
        }

        return convertedFilters;
    }
}
