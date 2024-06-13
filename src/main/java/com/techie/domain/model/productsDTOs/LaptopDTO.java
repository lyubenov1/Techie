package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class LaptopDTO {
    private ProductDTO product;

    private String screenSize;
    private String screenResolution;
    private String processor;
    private String gpu;
    private String ram;
    private String storageType;
    private String storage;
    private String operatingSystem;
    private String color;
    private int yearOfRelease;
}
