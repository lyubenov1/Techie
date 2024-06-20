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
import java.util.stream.*;

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
                               @RequestParam(required = false) Map<String, String> filters,
                               Model model) {

        Optional<Category> categoryOptional = categoryService.findByName(categoryName);
        if (categoryOptional.isEmpty()) {
            return "redirect:/";
        }

        CategoryDTO categoryDTO = categoryService.convertToDTO(categoryOptional.get());
        Map<String, List<String>> convertedFilters = convertFilters(filters);
        List<ProductDTO> filteredProducts = categoryService.getFilteredProducts(categoryName, convertedFilters);
        categoryDTO.setProducts(filteredProducts);

        model.addAttribute("category", categoryDTO);

        addFacets(categoryDTO, model);
        handlePagination(filteredProducts, model, page, size); // Pass filteredProducts instead of categoryDTO

        return "products";
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

    private void handlePagination(List<ProductDTO> products, Model model, int page, int size) {
        int totalProducts = products.size();
        int start = page * size;
        int end = Math.min(start + size, totalProducts);

        // Ensure start index is not out of bounds
        if (start >= totalProducts) {
            start = Math.max(0, totalProducts - size);
            end = totalProducts;
        }

        // Ensure end index is not out of bounds
        if (start < 0 || end > totalProducts) {
            start = 0;
            end = Math.min(size, totalProducts);
        }

        List<ProductDTO> paginatedProducts = products.subList(start, end);

        Page<ProductDTO> productsPage = new PageImpl<>(paginatedProducts, PageRequest.of(page, size), totalProducts);
        model.addAttribute("productsPage", productsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productsPage.getTotalPages());
        model.addAttribute("pageSize", size);
    }

    private void addFacets(CategoryDTO categoryDTO, Model model) {
        Map<String, String> filterCriteriaFields = retrieveFilterCriteriaFields(categoryDTO);
        Map<String, Map<String, Long>> filterOptions = retrieveFilterOptions(categoryDTO);

        model.addAttribute("filterCriteriaFields", filterCriteriaFields);
        model.addAttribute("filterOptions", filterOptions);
    }

    private Map<String, String> retrieveFilterCriteriaFields(CategoryDTO categoryDTO) {
        Map<String, String> filterCriteriaFields = new LinkedHashMap<>();
        filterCriteriaFields.put("brandName", "Brand");

        Set<String> processedFields = new HashSet<>(); // To avoid duplicate processing

        for (ProductDTO product : categoryDTO.getProducts()) {
            Class<? extends ProductDTO> productClass = product.getClass();   // Get inheriting child class to access its specific fields
            Field[] fields = productClass.getDeclaredFields();
            for (Field field : fields) {
                if (!field.getName().equals("brandName") && processedFields.add(field.getName())) {
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

    private Map<String, Map<String, Long>> retrieveFilterOptions(CategoryDTO categoryDTO) {
        Map<String, Map<String, Long>> filterOptions = new LinkedHashMap<>();

        for (ProductDTO product : categoryDTO.getProducts()) {
            Class<? extends ProductDTO> productClass = product.getClass();   // Get inheriting child class to access its specific fields
            Field[] fields = productClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                Map<String, Long> fieldOptions = filterOptions.computeIfAbsent(field.getName(), k -> new HashMap<>());

                try {
                    Object value = field.get(product);
                    if (value != null) {
                        String strValue = value.toString();
                        // Capitalize only the first character
                        String capitalizedValue = strValue.isEmpty() ? strValue : strValue.substring(0, 1).toUpperCase() + strValue.substring(1);
                        fieldOptions.put(capitalizedValue, fieldOptions.getOrDefault(capitalizedValue, 0L) + 1);                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Ensure brandName is always included
        Map<String, Long> brandOptions = new LinkedHashMap<>();
        for (ProductDTO product : categoryDTO.getProducts()) {
            String brand = product.getBrandName();
            if (brand != null) {
                brandOptions.put(brand, brandOptions.getOrDefault(brand, 0L) + 1);
            }
        }
        filterOptions.put("brandName", brandOptions);

        return filterOptions;
    }
}
