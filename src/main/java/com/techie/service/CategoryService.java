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

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAllJoinChildren();

        return categories.stream()
                .filter(category -> category.getParent() == null)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO(category.getId(), category.getName(), category.getImageUrl());
        List<Category> children = category.getChildren();
        StringBuilder urlBuilder = new StringBuilder();

        if (category.getParent() != null) {
            buildUrlRecursively(category.getParent(), urlBuilder);
        }

        String encodedName = UriUtils.encode(category.getName().toLowerCase().replace(" ", "-"), StandardCharsets.UTF_8);
        urlBuilder.append("/").append(encodedName);
        dto.setUrl(urlBuilder.toString());

        if (children != null) {
            List<CategoryDTO> childrenDTO = children.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            dto.setChildren(childrenDTO);
        }

        return dto;
    }

    private void buildUrlRecursively(Category category, StringBuilder urlBuilder) {
        if (category.getParent() != null) {
            buildUrlRecursively(category.getParent(), urlBuilder);
        }
        String encodedName = UriUtils.encode(category.getName().toLowerCase().replace(" ", "-"), StandardCharsets.UTF_8);
        urlBuilder.insert(0, "/" + encodedName);
    }

    public Optional<Category> findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

}