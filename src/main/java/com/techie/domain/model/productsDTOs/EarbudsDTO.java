package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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