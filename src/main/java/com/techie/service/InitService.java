package com.techie.service;

import com.techie.dataInitialization.*;
import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.repository.*;
import jakarta.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

/**
 * Service class responsible for initializing roles, categories, and product images.
 */
@Service
public class InitService {

    private final ProductImageRepository productImageRepository;
    private final ImageUrlRepo imageUrlRepo;
    private final ProductRepository productRepository;
    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public InitService(ProductImageRepository productImageRepository, ImageUrlRepo imageUrlRepo,
                       ProductRepository productRepository, RoleRepository roleRepository,
                       CategoryRepository categoryRepository) {
        this.productImageRepository = productImageRepository;
        this.imageUrlRepo = imageUrlRepo;
        this.productRepository = productRepository;
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * Initializes roles in the database if none exist.
     */
    @PostConstruct
    private void initRoles() {
        if (roleRepository.count() == 0) {
            // Create default roles
            RoleEntity userRole = RoleEntity.builder().role(UserRoleEnum.USER).build();
            RoleEntity moderatorRole = RoleEntity.builder().role(UserRoleEnum.MODERATOR).build();
            RoleEntity adminRole = RoleEntity.builder().role(UserRoleEnum.ADMIN).build();

            // Save roles to the repository
            roleRepository.save(userRole);
            roleRepository.save(moderatorRole);
            roleRepository.save(adminRole);
        }
    }

    /**
     * Establishes parent-child relationships between categories.
     */
    @PostConstruct
    private void initCategories() {
        // Group categories by their parent's ID
        Map<Long, List<Category>> childrenByParentId = categoryRepository.findAll().stream()
                .filter(category -> category.getParent() != null)
                .collect(Collectors.groupingBy(category -> category.getParent().getId()));

        categoryRepository.findAll().stream()
                .filter(category -> childrenByParentId.containsKey(category.getId()))
                .forEach(category -> category.setChildren(childrenByParentId.get(category.getId())));
    }

    /**
     * Saves product images to the database.
     * Associates images with products and marks the first image as primary.
     */
    public void saveProductImages() {
        // Check if there are any products in the repository
        if(productRepository.count() != 0) {
            // Retrieve image URLs mapped by product models
            Map<List<String>, List<String>> imageMap = imageUrlRepo.getImageMap();

            // Iterate over the image map and save each image
            imageMap.forEach((products, imageUrls) -> {
                for (String productModel : products) {
                    for (int i = 0; i < imageUrls.size(); i++) {
                        String imageUrl = imageUrls.get(i);

                        ProductImage productImage = new ProductImage();

                        // Find the product by its model name
                        Optional<Product> product = productRepository.findByName(productModel);
                        if (product.isPresent()) {
                            productImage.setProduct(product.get());
                            productImage.setImageUrl(imageUrl);
                            if (i == 0) {
                                // Set the first image as primary
                                productImage.setPrimary(true);
                            }
                            // Save the product image to the repository
                            productImageRepository.save(productImage);
                        }
                    }
                }
            });
        }
    }

}