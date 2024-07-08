package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;

import java.util.*;
import java.util.stream.*;

public class UserConversionUtils {

    public static AddressDTO convertToDto(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .country(address.getCountry())
                .zipcode(address.getZipcode())
                .build();
    }

    public static UserDTO convertToDto(UserEntity user) {
        List<AddressDTO> addressDTOs = user.getAddresses().stream()
                .map(UserConversionUtils::convertToDto)
                .collect(Collectors.toList());

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .addresses(addressDTOs)
                .build();
    }

}
