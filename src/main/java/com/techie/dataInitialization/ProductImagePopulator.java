package com.techie.dataInitialization;

import com.techie.repository.ProductImageRepository;
import com.techie.service.ProductImageService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
 public class ProductImagePopulator {

     private final ProductImageService productImageService;
     private final ProductImageRepository productImageRepository;

     @Autowired
     public ProductImagePopulator(ProductImageService productImageService,
                                  ProductImageRepository productImageRepository) {
         this.productImageService = productImageService;
         this.productImageRepository = productImageRepository;
     }

     @PostConstruct
     public void populateProductImageEntity() {
         if(productImageRepository.count() == 0) {
             productImageService.saveProductImages();
         }
     }
 }


// database must first be populated through data.sql