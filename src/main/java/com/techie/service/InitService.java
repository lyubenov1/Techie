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

    @PostConstruct
    private void initRoles() {
        if (roleRepository.count() == 0) {

            RoleEntity userRole = RoleEntity.builder()
                    .role(UserRoleEnum.USER)
                    .build();

            RoleEntity adminRole = RoleEntity.builder()
                    .role(UserRoleEnum.ADMIN)
                    .build();

            roleRepository.save(userRole);
            roleRepository.save(adminRole);
        }
    }

    @PostConstruct
    private void initCategories() {
        Map<Long, List<Category>> childrenByParentId = categoryRepository.findAll().stream()
                .filter(category -> category.getParent() != null)
                .collect(Collectors.groupingBy(category -> category.getParent().getId()));

        categoryRepository.findAll().stream()
                .filter(category -> childrenByParentId.containsKey(category.getId()))
                .forEach(category -> category.setChildren(childrenByParentId.get(category.getId())));
    }

    public void saveProductImages() {
        if(productRepository.count() != 0) {
            Map<List<String>, List<String>> imageMap = imageUrlRepo.getImageMap();

            imageMap.forEach((products, imageUrls) -> {
                for (String productModel : products) {
                    for (String imageUrl : imageUrls) {
                        ProductImage productImage = new ProductImage();

                        Optional<Product> product = productRepository.findByName(productModel);
                        if (product.isPresent()) {
                            productImage.setProduct(product.get());
                            productImage.setImageUrl(imageUrl);
                            productImageRepository.save(productImage);
                        }
                    }
                }
            });
        }
    }

}