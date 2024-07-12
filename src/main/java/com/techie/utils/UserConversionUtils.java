package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
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

    public static UserDisplayView convertToView(UserEntity user) {
        List<AddressDTO> addressDTOs = user.getAddresses().stream()
                .map(UserConversionUtils::convertToDto)
                .collect(Collectors.toList());

        return UserDisplayView.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .profileImageUrl(user.getProfileImageUrl())
                .addresses(addressDTOs)
                .build();
    }

    public static UserEntity convertToEntity(UserDisplayView userDisplayView) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDisplayView.getId());
        userEntity.setUsername(userDisplayView.getUsername());
        userEntity.setEmail(userDisplayView.getEmail());
        userEntity.setFirstName(userDisplayView.getFirstName());
        userEntity.setLastName(userDisplayView.getLastName());
        userEntity.setProfileImageUrl(userDisplayView.getProfileImageUrl());

        // Convert addresses from DTO to Entity
        Set<Address> addresses = userDisplayView.getAddresses().stream()
                .map(UserConversionUtils::convertToEntity)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        userEntity.setAddresses(addresses);

        return userEntity;
    }

    // New method to convert AddressDTO to Address entity
    public static Address convertToEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setZipcode(addressDTO.getZipcode());
        return address;
    }

}