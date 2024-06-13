package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PowerBankDTO {
    private ProductDTO product;

    private String batteryCapacity;
    private String color;
}