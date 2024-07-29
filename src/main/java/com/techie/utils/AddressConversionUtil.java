package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;

public class AddressConversionUtil {

    public static AddressDTO convertToDTO(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .name(address.getName())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .country(address.getCountry())
                .zipcode(address.getZipcode())
                .build();
    }

    public static Address convertToEntity(AddressDTO addressDTO) {
        return Address.builder()
                .name(addressDTO.getName())
                .addressLine1(addressDTO.getAddressLine1())
                .addressLine2(addressDTO.getAddressLine2())
                .city(addressDTO.getCity())
                .country(addressDTO.getCountry())
                .zipcode(addressDTO.getZipcode())
                .build();
    }
}
