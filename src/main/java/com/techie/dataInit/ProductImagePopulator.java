package com.techie.dataInit;

import com.techie.service.*;
import jakarta.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
  public class ProductImagePopulator {

      private final ProductImageService productImageService;

      @Autowired
      public ProductImagePopulator(ProductImageService productImageService) {
          this.productImageService = productImageService;
      }

      @PostConstruct
      public void populateProductImageEntity() {
          productImageService.saveProductImages();
      }
  }