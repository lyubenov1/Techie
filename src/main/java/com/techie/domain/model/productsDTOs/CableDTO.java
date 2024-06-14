package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "cableBuilder")
public class CableDTO extends ProductDTO {

    private String type;

}