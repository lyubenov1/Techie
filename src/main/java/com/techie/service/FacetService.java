package com.techie.service;

import com.techie.domain.model.*;
import com.techie.utils.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

@Service
public class FacetService {

    public void addFacets(CategoryDTO categoryDTO, Model model) {
        model.addAttribute("filterCriteriaFields", retrieveFilterCriteriaFields(categoryDTO));
        model.addAttribute("filterOptions", retrieveFilterOptions(categoryDTO));
    }

    private Map<String, String> retrieveFilterCriteriaFields(CategoryDTO categoryDTO) {
        Map<String, String> filterCriteriaFields = new LinkedHashMap<>();
        filterCriteriaFields.put("brandName", "Brand");

        Set<String> processedFields = new HashSet<>();
        for (ProductDTO product : categoryDTO.getProducts()) {
            for (Field field : getAllFields(product)) {
                if (processedFields.add(field.getName()) && !field.getName().equals("brandName")) {
                    filterCriteriaFields.put(field.getName(), styleFieldName(field.getName()));
                }
            }
        }
        return filterCriteriaFields;
    }

    private Map<String, Map<String, Long>> retrieveFilterOptions(CategoryDTO categoryDTO) {
        Map<String, Map<String, Long>> filterOptions = new LinkedHashMap<>();

        for (ProductDTO product : categoryDTO.getProducts()) {
            for (Field field : getAllFields(product)) {
                field.setAccessible(true);
                Map<String, Long> fieldOptions = filterOptions.computeIfAbsent(field.getName(), k -> new HashMap<>());

                try {
                    Object value = field.get(product);
                    if (value != null) {
                        String capitalizedValue = CaseStyleUtil.capitalizeFirstLetter(value.toString());
                        fieldOptions.put(capitalizedValue, fieldOptions.getOrDefault(capitalizedValue, 0L) + 1);
                    }
                } catch (IllegalAccessException e) {
                    // Use a logger instead of printStackTrace in production code
                    e.printStackTrace();
                }
            }
        }

        // Ensure brandName is always included
        Map<String, Long> brandOptions = categoryDTO.getProducts().stream()
                .map(ProductDTO::getBrandName)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(brand -> brand, LinkedHashMap::new, Collectors.counting()));

        filterOptions.put("brandName", brandOptions);
        return filterOptions;
    }

    private List<Field> getAllFields(ProductDTO product) {
        List<Field> fields = new ArrayList<>();
        Class<?> clazz = product.getClass();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    private String styleFieldName(String fieldName) {
        String styledName = CaseStyleUtil.camelCaseToWords(fieldName);
        if ("batteryCapacity".equals(fieldName)) {
            styledName += " (mAh)";
        }
        return styledName;
    }

}
