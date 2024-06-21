package com.techie.service;

import com.techie.domain.model.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import java.lang.reflect.*;
import java.util.*;

@Service
public class FacetService {

    public void addFacets(CategoryDTO categoryDTO, Model model) {
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
