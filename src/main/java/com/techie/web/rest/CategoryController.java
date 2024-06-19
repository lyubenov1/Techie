package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.getParentCategoryDTOs();
    }

    @GetMapping("/{categoryName}/products")
    public List<ProductDTO> getFilteredProducts(@PathVariable String categoryName,
                                                @RequestParam Map<String, String> filters) {

        Map<String, List<String>> convertedFilters = convertFilters(filters);
        return categoryService.getFilteredProducts(categoryName, convertedFilters);
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