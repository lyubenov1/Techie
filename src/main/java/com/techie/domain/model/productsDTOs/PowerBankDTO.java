package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PowerBankDTO extends ProductDTO {

    private String batteryCapacity;
    private String color;

}