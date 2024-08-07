package com.techie.service;

import com.techie.domain.model.DTOs.*;
import com.techie.utils.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

@Service
public class FacetService {

    public void addFacets(List<ProductDTO> products, Model model) {
        model.addAttribute("filterCriteriaFields", retrieveFilterCriteriaFields(products));
        model.addAttribute("filterOptions", retrieveFilterOptions(products));
    }

    private Map<String, String> retrieveFilterCriteriaFields(List<ProductDTO> products) {
        Map<String, String> filterCriteriaFields = new LinkedHashMap<>();
        filterCriteriaFields.put("brandName", "Brand");     // The filters should have all inheritor fields plus brandName field from the base ProductDTO

        Set<String> processedFields = new HashSet<>();     // To avoid duplicate processing

        for (ProductDTO product : products) {
            for (Field field : FieldUtil.getFields(product)) {
                if (processedFields.add(field.getName()) && !field.getName().equals("brandName")) {
                    filterCriteriaFields.put(field.getName(), CaseStyleUtil.styleFieldName(field.getName()));
                }
            }
        }
        return filterCriteriaFields;       // Return a map of the original field name and its corresponding user-friendly format.
    }

    private Map<String, Map<String, Long>> retrieveFilterOptions(List<ProductDTO> products) {
        Map<String, Map<String, Long>> filterOptions = new LinkedHashMap<>();

        for (ProductDTO product : products) {
            for (Field field : FieldUtil.getFields(product)) {
                field.setAccessible(true);
                Map<String, Long> fieldOptions = filterOptions.computeIfAbsent(field.getName(), k -> new HashMap<>());
                processFieldValue(field, product, fieldOptions);
            }
        }
        ensureBrandNameIncluded(products, filterOptions);
        return filterOptions;               // Return a map of original field name (the key),
                                            // all productDTOs' values that match the given field, and a counter for each value
    }

    private void processFieldValue(Field field, ProductDTO product, Map<String, Long> fieldOptions) {
        try {
            Object value = field.get(product);
            if (value != null) {
                String capitalizedValue = CaseStyleUtil.capitalizeFirstLetter(value.toString());
                fieldOptions.put(capitalizedValue, fieldOptions.getOrDefault(capitalizedValue, 0L) + 1);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void ensureBrandNameIncluded(List<ProductDTO> products, Map<String, Map<String, Long>> filterOptions) {
        Map<String, Long> brandOptions = products.stream()
                .map(ProductDTO::getBrandName)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(brand -> brand, LinkedHashMap::new, Collectors.counting()));

        filterOptions.put("brandName", brandOptions);
    }
}
