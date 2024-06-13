package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SmartphoneDTO {
    private ProductDTO product;

    private String screenSize;
    private String screenResolution;
    private String ram;
    private String storage;
    private String batteryCapacity;
    private String frontCamera;
    private String rearCamera;
    private String refreshRate;
    private String color;
    private String operatingSystem;
    private int yearOfRelease;
}