package com.techie.domain.model.DTOs.productsDTOs;

import com.techie.domain.model.DTOs.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "chargerBuilder")
public class ChargerDTO extends ProductDTO {

    private String adapterType;

}
