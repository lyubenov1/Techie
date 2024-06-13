package com.techie.domain.model.productsDTOs;

import com.techie.domain.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CableDTO {
    private ProductDTO product;

    private String type;
}