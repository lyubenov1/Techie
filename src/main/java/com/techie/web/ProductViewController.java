package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/products")
public class ProductViewController {

    private final CategoryService categoryService;
    private final ProductFilterService productFilterService;
    private final PaginationService paginationService;
    private final FacetService facetService;
    private final ProductService productService;

    @Autowired
    public ProductViewController(CategoryService categoryService, ProductFilterService productFilterService,
                                 PaginationService paginationService, FacetService facetService,
                                 ProductService productService) {
        this.categoryService = categoryService;
        this.productFilterService = productFilterService;
        this.paginationService = paginationService;
        this.facetService = facetService;
        this.productService = productService;
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam String query,
                                 @RequestParam(required = false) Map<String, String> filters,
                                 @RequestParam(name = "p", defaultValue = "0", required = false) int page,
                                 @RequestParam(name = "sort", defaultValue = "newest", required = false) String sort,
                                 Model model) {
        filters.remove("p");
        filters.remove("sort");
        filters.remove("query");

        List<ProductDTO> searchResults = productService.fullSearchProducts(query);

        model.addAttribute("products", searchResults);
        model.addAttribute("searchQuery", query);

        facetService.addFacets(searchResults, model);
        paginationService.handlePagination(searchResults, model, page, PaginationService.DEFAULT_PAGE_SIZE);

        return "products";
    }

    @GetMapping
    public String productsPage(@RequestParam(required = false) Map<String, String> filters,
                               @RequestParam(name = "p", defaultValue = "0", required = false) int page,
                               @RequestParam(name = "sort", defaultValue = "newest", required = false) String sort,
                               Model model) {
        filters.remove("p");
        filters.remove("sort");

        List<CategoryDTO> parentCategories = categoryService.getParentCategoryDTOs();
        List<ProductDTO> filteredProducts = productFilterService.getFilteredProductsAll(parentCategories, filters, sort);

        model.addAttribute("products", filteredProducts);

        facetService.addFacets(filteredProducts, model);
        paginationService.handlePagination(filteredProducts, model, page, PaginationService.DEFAULT_PAGE_SIZE);

        return "products";
    }

    @GetMapping("/weekly-deals")
    public String weeklyDealsPage() {
        return "weekly-deals";
    }


    @GetMapping("/{categoryName}")
    public String categoryPage(@PathVariable String categoryName,
                               @RequestParam(required = false) Map<String, String> filters,
                               @RequestParam(name = "p", defaultValue = "0", required = false) int page,
                               @RequestParam(name = "sort", defaultValue = "newest", required = false) String sort,
                               Model model) {
        filters.remove("p");
        filters.remove("sort");

        Optional<Category> categoryOptional = categoryService.findByName(categoryName);
        if (categoryOptional.isEmpty()) {
            return "redirect:/";
        }

        CategoryDTO categoryDTO = categoryService.convertToDTO(categoryOptional.get());

        List<ProductDTO> filteredProducts = productFilterService.getFilteredProducts(categoryName, filters, sort);
        categoryDTO.setProducts(filteredProducts);

        model.addAttribute("category", categoryDTO);

        facetService.addFacets(filteredProducts, model);
        paginationService.handlePagination(filteredProducts, model, page, PaginationService.DEFAULT_PAGE_SIZE);

        return "products";
    }

    @GetMapping("/{categoryName}/{productName}")
    public String productPage(@PathVariable String productName, Model model) {
        Optional<Product> productOptional = productService.findByNameIgnoreCase(productName);

        if (productOptional.isEmpty()) {
            return "redirect:/products";
        }

        ProductDTO productDTO = productService.convertToDTO(productOptional.get());
        productService.addSpecifications(productDTO, model);

        model.addAttribute("product", productDTO);
        return "productPage";
    }


}
