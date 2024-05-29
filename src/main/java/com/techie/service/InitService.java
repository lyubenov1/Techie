package com.techie.service;

import com.techie.dataInitialization.ImageUrlRepo;
import com.techie.domain.entities.Product;
import com.techie.domain.entities.ProductImage;
import com.techie.domain.entities.RoleEntity;
import com.techie.domain.enums.UserRoleEnum;
import com.techie.repository.ProductImageRepository;
import com.techie.repository.ProductRepository;
import com.techie.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InitService {

    private final ProductImageRepository productImageRepository;
    private final ProductService productService;
    private final ImageUrlRepo imageUrlRepo;
    private final ProductRepository productRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public InitService(ProductImageRepository productImageRepository, ProductService productService,
                       ImageUrlRepo imageUrlRepo, ProductRepository productRepository,
                       RoleRepository roleRepository) {
        this.productImageRepository = productImageRepository;
        this.productService = productService;
        this.imageUrlRepo = imageUrlRepo;
        this.productRepository = productRepository;
        this.roleRepository = roleRepository;
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

    public void saveProductImages() {
        if(productRepository.count() != 0) {
            Map<List<String>, List<String>> imageMap = imageUrlRepo.getImageMap();

            imageMap.forEach((products, imageUrls) -> {
                for (String productModel : products) {
                    for (String imageUrl : imageUrls) {
                        ProductImage productImage = new ProductImage();

                        Product product = productService.findByName(productModel);
                        productImage.setProduct(product);
                        productImage.setImageUrl(imageUrl);
                        productImageRepository.save(productImage);
                    }
                }
            });
        }
    }

}