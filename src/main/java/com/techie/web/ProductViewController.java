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

    @GetMapping("/weekly-deals")
    public String weeklyDealsPage() {
        return "weekly-deals";
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
    public String productPage(@PathVariable String productName, @PathVariable String categoryName, Model model) {
        Optional<Product> productOptional = productService.findByNameIgnoreCase(productName);

        if (productOptional.isEmpty()) {
            return "redirect:/products";
        }

        ProductDTO productDTO = productService.convertToDTO(productOptional.get());
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
