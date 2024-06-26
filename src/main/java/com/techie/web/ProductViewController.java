package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.service.*;
import org.slf4j.*;
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
    private final Logger logger = LoggerFactory.getLogger(ProductViewController.class);

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

    @GetMapping
    public String productsPage() {
        return "weekly-deals";
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
        logger.info("Category: {}, Filters: {}, Page: {}", categoryName, filters, page);
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

        facetService.addFacets(categoryDTO, model);
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

        model.addAttribute("product", productDTO);
        return "productPage";
    }


}
