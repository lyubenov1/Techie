package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.*;
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

        // Retrieve filter criteria fields
        Map<String, String> filterCriteriaFields = retrieveFilterCriteriaFields(categoryDTO);
        model.addAttribute("filterCriteriaFields", filterCriteriaFields);


        List<ProductDTO> products = categoryDTO.getProducts();
        int start = page * size;
        int end = Math.min(start + size, products.size());
        List<ProductDTO> paginatedProducts = products.subList(start, end);

        Page<ProductDTO> productsPage = new PageImpl<>(paginatedProducts, PageRequest.of(page, size), products.size());
        model.addAttribute("productsPage", productsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productsPage.getTotalPages());
        model.addAttribute("pageSize", size);

        return "products";
    }

    private Map<String, String> retrieveFilterCriteriaFields(CategoryDTO categoryDTO) {
        Map<String, String> filterCriteriaFields = new LinkedHashMap<>();
        filterCriteriaFields.put("brandName", "Brand");

        if (!categoryDTO.getProducts().isEmpty()) {
            ProductDTO sampleProduct = categoryDTO.getProducts().getFirst();
            Class<? extends ProductDTO> productClass = sampleProduct.getClass();
            Field[] fields = productClass.getDeclaredFields();
            for (Field field : fields) {
                if (!field.getName().equals("brandName")) {
                    String styledName = camelCaseToWords(field.getName());

                    if (field.getName().equals("batteryCapacity")) {
                        styledName += " (mAh)";
                    }
                    filterCriteriaFields.put(field.getName(), styledName);
                }
            }
        }
        return filterCriteriaFields;
    }

    private String camelCaseToWords(String camelCase) {
        String[] words = camelCase.split("(?=[A-Z])"); // Split on uppercase letters

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (i == 0) {
                result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
            } else {
                result.append(word.substring(0, 1).toLowerCase()).append(word.substring(1));
            }

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

}
