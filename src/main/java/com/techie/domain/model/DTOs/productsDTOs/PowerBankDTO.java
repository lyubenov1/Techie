package com.techie.domain.model.DTOs.productsDTOs;

import com.techie.domain.model.DTOs.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "powerBankBuilder")
public class PowerBankDTO extends ProductDTO {

    private String batteryCapacity;
    private String color;

}