package com.techie.service;

import com.techie.dataInit.*;
import com.techie.domain.entities.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductService productService;
    private final ImageUrlRepo imageUrlRepo;

    @Autowired
    public ProductImageService(ProductImageRepository productImageRepository, ProductService productService,
                               ImageUrlRepo imageUrlRepo) {
        this.productImageRepository = productImageRepository;
        this.productService = productService;
        this.imageUrlRepo = imageUrlRepo;
    }

    public void saveProductImages() {
        Map<List<String>, List<String>> imageMap = imageUrlRepo.getImageMap();

        imageMap.forEach((phoneModels, imageUrls) -> {
            for (String phoneModel : phoneModels) {
                for (String imageUrl : imageUrls) {
                    ProductImage productImage = new ProductImage();

                    Product product = productService.findByName(phoneModel);
                    productImage.setProduct(product);
                    productImage.setImageUrl(imageUrl);
                    productImageRepository.save(productImage);
                }
            }
        });
    }

}