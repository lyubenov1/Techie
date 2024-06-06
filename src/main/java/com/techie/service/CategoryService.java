package com.techie.service;

import com.techie.domain.entities.Category;
import com.techie.domain.model.CategoryDTO;
import com.techie.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllParentCategoriesWithChildren() {
        List<Category> parentCategories = categoryRepository.findAllByParentIsNull();
        logger.info("Parent Categories: {}", parentCategories);

        List<CategoryDTO> parentCategoriesDTO = parentCategories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        logger.info("Parent Categories DTO: {}", parentCategoriesDTO);

        return parentCategoriesDTO;
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO(category.getId(), category.getName(), category.getImageUrl());
        List<Category> children = getChildren(category);
        logger.info("Children for {}: {}", category.getName(), children);

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