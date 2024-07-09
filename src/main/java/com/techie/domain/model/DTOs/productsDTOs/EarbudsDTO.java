package com.techie.domain.model.DTOs.productsDTOs;

import com.techie.domain.model.DTOs.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "earbudsBuilder")
public class EarbudsDTO extends ProductDTO {

    private String connectionType;
    private String batteryLife;
    private String batteryLifeWithCase;
    private boolean anc;
    private String bluetoothVersion;
    private String fit;
    private String color;
    private int yearOfRelease;

}