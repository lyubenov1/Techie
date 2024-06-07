package com.techie.service;

import com.techie.domain.entities.Category;
import com.techie.domain.model.CategoryDTO;
import com.techie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return dto;
    }

    private List<Category> getChildren(Category category) {
        return categoryRepository.findChildrenByParentId(category.getId());
    }
}