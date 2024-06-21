package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductFilterService productFilterService;
    private final PaginationService paginationService;

    @Autowired
    public CategoryController(CategoryService categoryService, ProductFilterService productFilterService,
                              PaginationService paginationService) {
        this.categoryService = categoryService;
        this.productFilterService = productFilterService;
        this.paginationService = paginationService;
    }

    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.getParentCategoryDTOs();
    }

    @GetMapping("/products/{categoryName}")
    public Page<ProductDTO> getFilteredProducts(@PathVariable String categoryName,
                                                @RequestParam(required = false) Map<String, String> filters,
                                                @RequestParam(name = "page", defaultValue = "0") int page,
                                                @RequestParam(name = "size", defaultValue = "25") int size) {

        List<ProductDTO> filteredProducts = productFilterService.getFilteredProducts(categoryName, filters);
        return paginationService.paginate(filteredProducts, page, size);
    }
}