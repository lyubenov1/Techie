package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "chargerBuilder")
public class ChargerDTO extends ProductDTO {

    private String adapterType;

}
