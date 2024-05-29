package com.techie.dataInitialization;

import com.techie.repository.ProductImageRepository;
import com.techie.service.InitService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
 public class ProductImagePopulator {

     private final InitService initService;
     private final ProductImageRepository productImageRepository;

     @Autowired
     public ProductImagePopulator(InitService initService,
                                  ProductImageRepository productImageRepository) {
         this.initService = initService;
         this.productImageRepository = productImageRepository;
     }

     @PostConstruct
     public void populateProductImageEntity() {
         if(productImageRepository.count() == 0) {
             initService.saveProductImages();
         }
     }
 }


// database must first be populated through data.sql