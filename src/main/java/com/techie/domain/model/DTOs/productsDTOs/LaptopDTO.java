package com.techie.domain.model.DTOs.productsDTOs;

import com.techie.domain.model.DTOs.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "laptopBuilder")
public class LaptopDTO extends ProductDTO {

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
