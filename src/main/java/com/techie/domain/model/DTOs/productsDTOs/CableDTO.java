package com.techie.domain.model.DTOs.productsDTOs;

import com.techie.domain.model.DTOs.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "cableBuilder")
public class CableDTO extends ProductDTO {

    private String type;

}