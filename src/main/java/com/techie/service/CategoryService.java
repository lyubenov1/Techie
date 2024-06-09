package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.util.*;

import java.nio.charset.*;
import java.util.*;
import java.util.stream.*;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllParentCategoriesWithChildren() {
        List<Category> parentCategories = categoryRepository.findAllByParentIsNull();

        return parentCategories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO(category.getId(), category.getName(), category.getImageUrl());
        List<Category> children = getChildren(category);

        List<CategoryDTO> childrenDTO = children.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        dto.setChildren(childrenDTO);
        setCategoryUrl(dto);
        return dto;
    }

    public void setCategoryUrl(CategoryDTO categoryDTO) {
        Optional<Category> categoryOptional = categoryRepository.findByNameWithParent(categoryDTO.getName());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            // Build URL based on the category hierarchy
            StringBuilder urlBuilder = new StringBuilder();

            // Check if the category has a parent
            while (category != null) {
                String encodedName = UriUtils.encode(category.getName().toLowerCase().replace(" ", "-"), StandardCharsets.UTF_8);
                urlBuilder.insert(0, "/" + encodedName); // Insert the encoded segment
                category = category.getParent(); // Move to the parent category
            }

            categoryDTO.setUrl(urlBuilder.toString());
        }
    }

    private List<Category> getChildren(Category category) {
        return categoryRepository.findChildrenByParentId(category.getId());
    }

    public Optional<Category> findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    public Optional<Category> findByNameWithParent(String categoryName) {
        return categoryRepository.findByNameWithParent(categoryName);
    }
}