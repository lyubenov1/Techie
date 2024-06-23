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

    @Autowired
    public ProductViewController(CategoryService categoryService, ProductFilterService productFilterService,
                                 PaginationService paginationService, FacetService facetService) {
        this.categoryService = categoryService;
        this.productFilterService = productFilterService;
        this.paginationService = paginationService;
        this.facetService = facetService;
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
                               @RequestParam(name = "p", defaultValue = "0") int page,
                               Model model) {

        Optional<Category> categoryOptional = categoryService.findByName(categoryName);
        if (categoryOptional.isEmpty()) {
            return "redirect:/";
        }

        CategoryDTO categoryDTO = categoryService.convertToDTO(categoryOptional.get());

        List<ProductDTO> filteredProducts = productFilterService.getFilteredProducts(categoryName, filters);
        categoryDTO.setProducts(filteredProducts);

        model.addAttribute("category", categoryDTO);

        facetService.addFacets(categoryDTO, model);
        paginationService.handlePagination(filteredProducts, model, page, PaginationService.DEFAULT_PAGE_SIZE);

        return "products";
    }

}
