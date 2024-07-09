package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

@Service
public class ProductFilterService {
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductFilterService(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    public List<ProductDTO> getFilteredSearchProducts(Map<String, String> filters, String sort, String searchQuery) {
        if (searchQuery == null || searchQuery.length() < 3) {
            return Collections.emptyList(); // Return empty list if query length is less than 3
        }

        List<ProductDTO> products = productService.fullSearchProducts(searchQuery);

        Map<String, List<String>> convertedFilters = convertFilters(filters);    // Convert the checked filter options to an easier format to work with
        applyFilters(products, convertedFilters);
        applySorting(products, sort);

        return products;
    }

    public List<ProductDTO> getFilteredProductsAll(List<CategoryDTO> categories, Map<String, String> filters, String sort) {
        List<ProductDTO> filteredProducts = new ArrayList<>();

        for (CategoryDTO category : categories) {
            filteredProducts.addAll(getFilteredProducts(category.getName(), filters, sort));
        }

        return filteredProducts;
    }

    public List<ProductDTO> getFilteredProducts(String categoryName, Map<String, String> filters, String sort) {
        Optional<Category> categoryOptional = categoryService.findByName(categoryName);
        Map<String, List<String>> convertedFilters = convertFilters(filters);     // Convert the checked filter options to an easier format to work with

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            List<ProductDTO> products = categoryService.fetchProductsForCategory(category);
            applyFilters(products, convertedFilters);
            applySorting(products, sort);

            return products;
        } else {
            throw new CategoryNotFoundException("Category with name " + categoryName + " not found");
        }
    }

    private void applySorting(List<ProductDTO> products, String sort) {
        switch (sort) {
            case "price-low-high":
                products.sort(Comparator.comparing(ProductDTO::getOriginalPrice));
                break;
            case "price-high-low":
                products.sort(Comparator.comparing(ProductDTO::getOriginalPrice).reversed());
                break;
            case "rating":
                products.sort(Comparator.comparing(ProductDTO::getAverageRating).reversed());
                break;
            case "newest":
            default:
                sortByNewest(products);
                break;
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

    private void sortByNewest(List<ProductDTO> products) {
        products.sort((p1, p2) -> {
            Class<?> class1 = p1.getClass();
            Class<?> class2 = p2.getClass();

            boolean hasYearOfRelease1 = hasYearOfReleaseField(class1);
            boolean hasYearOfRelease2 = hasYearOfReleaseField(class2);

            if (hasYearOfRelease1 && hasYearOfRelease2) {
                return compareByYearOfRelease(p1, p2);        // If both products have yearOfRelease field, sort them by newest first.
                                                              // If only one has it, make the ones with such field a priority.
                                                              // If both products don't have it, sort them by name alphabetically.
            } else if (hasYearOfRelease1) {
                return -1; // p1 comes first
            } else if (hasYearOfRelease2) {
                return 1;  // p2 comes first
            } else {
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    private boolean hasYearOfReleaseField(Class<?> clazz) {
        try {
            clazz.getDeclaredField("yearOfRelease");
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    private int compareByYearOfRelease(ProductDTO p1, ProductDTO p2) {
        try {
            Field field1 = p1.getClass().getDeclaredField("yearOfRelease");
            Field field2 = p2.getClass().getDeclaredField("yearOfRelease");
            field1.setAccessible(true);
            field2.setAccessible(true);
            int year1 = (int) field1.get(p1);
            int year2 = (int) field2.get(p2);
            return Integer.compare(year2, year1); // Newest first
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // This shouldn't happen as we've already checked for the field's existence
            return 0;
        }
    }
}
