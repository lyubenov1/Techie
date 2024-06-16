package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/products")
public class ProductViewController {

    private final CategoryService categoryService;

    @Autowired
    public ProductViewController(CategoryService categoryService) {
        this.categoryService = categoryService;
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
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "25") int size,
                               Model model) {
        Optional<Category> categoryOptional = categoryService.findByName(categoryName);
        if (categoryOptional.isEmpty()) {
            return "redirect:/";
        }

        CategoryDTO categoryDTO = categoryService.convertToDTO(categoryOptional.get());
        model.addAttribute("category", categoryDTO);

        List<ProductDTO> products = categoryDTO.getProducts();
        int start = page * size;
        int end = Math.min(start + size, products.size());
        List<ProductDTO> paginatedProducts = products.subList(start, end);

        Page<ProductDTO> productsPage = new PageImpl<>(paginatedProducts, PageRequest.of(page, size), products.size());
        model.addAttribute("productsPage", productsPage);

        return "products";
    }
}
