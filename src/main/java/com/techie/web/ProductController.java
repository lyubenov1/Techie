package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.category.*;
import com.techie.exceptions.product.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final CategoryService categoryService;
    private final ProductFilterService productFilterService;
    private final PaginationService paginationService;
    private final FacetService facetService;
    private final ProductService productService;

    @Autowired
    public ProductController(CategoryService categoryService, ProductFilterService productFilterService,
                             PaginationService paginationService, FacetService facetService,
                             ProductService productService) {
        this.categoryService = categoryService;
        this.productFilterService = productFilterService;
        this.paginationService = paginationService;
        this.facetService = facetService;
        this.productService = productService;
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam(name = "q", required = false) String query,
                                 @RequestParam(required = false) Map<String, String> filters,
                                 @RequestParam(name = "p", defaultValue = "0", required = false) int page,
                                 @RequestParam(name = "sort", defaultValue = "newest", required = false) String sort,
                                 Model model) {
        filters.remove("p");
        filters.remove("sort");
        filters.remove("q");

        List<ProductDTO> filteredProducts = productFilterService.getFilteredSearchProducts(filters, sort, query);

        model.addAttribute("searchQuery", query);

        if (filteredProducts.isEmpty()) {
            return "error-pages/search-not-found";
        }

        model.addAttribute("products", filteredProducts);

        facetService.addFacets(filteredProducts, model);
        paginationService.handlePagination(filteredProducts, model, page, PaginationService.DEFAULT_PAGE_SIZE);

        return "products";
    }

    @GetMapping
    public String allProductsPage(@RequestParam(required = false) Map<String, String> filters,
                               @RequestParam(name = "p", defaultValue = "0", required = false) int page,
                               @RequestParam(name = "sort", defaultValue = "newest", required = false) String sort,
                               Model model) throws CategoryNotFoundException {
        filters.remove("p");
        filters.remove("sort");

        List<CategoryDTO> parentCategories = categoryService.getParentCategoryDTOs();
        List<ProductDTO> filteredProducts = productFilterService.getFilteredProductsAll(parentCategories, filters, sort);

        model.addAttribute("products", filteredProducts);

        facetService.addFacets(filteredProducts, model);
        paginationService.handlePagination(filteredProducts, model, page, PaginationService.DEFAULT_PAGE_SIZE);

        return "products";
    }

    @GetMapping("/{categoryName}")
    public String categoryPage(@PathVariable String categoryName,
                               @RequestParam(required = false) Map<String, String> filters,
                               @RequestParam(name = "p", defaultValue = "0", required = false) int page,
                               @RequestParam(name = "sort", defaultValue = "newest", required = false) String sort,
                               Model model) throws CategoryNotFoundException {
        filters.remove("p");
        filters.remove("sort");

        CategoryDTO categoryDTO = categoryService.findByNameAndConvert(categoryName);
        List<ProductDTO> filteredProducts = productFilterService.getFilteredProducts(categoryName, filters, sort);
        categoryDTO.setProducts(filteredProducts);

        model.addAttribute("category", categoryDTO);

        facetService.addFacets(filteredProducts, model);
        paginationService.handlePagination(filteredProducts, model, page, PaginationService.DEFAULT_PAGE_SIZE);

        return "products";
    }

    @GetMapping("/{categoryName}/{productName}")
    public String productPage(@PathVariable String productName, @PathVariable String categoryName,
                              Model model) throws ProductNotFoundException, CategoryNotFoundException {
        ProductDTO productDTO = productService.findByNameWithAllImages(productName);

        Category category = categoryService.findByName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException(categoryName));

        productService.addSpecifications(productDTO, model);

        model.addAttribute("product", productDTO);
        return "product-page";
    }

    @GetMapping("/compare-products")
    public String compareProductsPage(
            @RequestParam(required = false) Long idProduct1,
            @RequestParam(required = false) Long idProduct2,
            @RequestParam(required = false) Long idProduct3,
            Model model) {

        addProductToModel(idProduct1, model, "product1", "specifications1");
        addProductToModel(idProduct2, model, "product2", "specifications2");
        addProductToModel(idProduct3, model, "product3", "specifications3");

        Set<String> specificationKeys = productService.retrieveSpecificationKeys(idProduct1, idProduct2, idProduct3);
        model.addAttribute("specificationKeys", specificationKeys);

        return "compare-products";
    }

    private void addProductToModel(Long productId, Model model, String attributeName, String specsAttributeName) {
        if (productId != null) {
            Optional<Product> productOptional = productService.findById(productId);
            productOptional.ifPresent(product -> {
                ProductDTO productDTO = productService.convertToDTO(product);
                Map<String, String> specifications = productService.retrieveSpecifications(productDTO);
                model.addAttribute(attributeName, productDTO);
                model.addAttribute(specsAttributeName, specifications);
            });
        }
    }

}
