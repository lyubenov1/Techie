package com.techie.domain.model.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private Long id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String zipcode;
}
