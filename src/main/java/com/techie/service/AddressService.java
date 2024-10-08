package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.address.*;
import com.techie.repository.*;
import com.techie.utils.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;


@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO convertToDTO(Address address){
        return AddressConversionUtil.convertToDTO(address);
    }

    @Transactional
    public AddressDTO createAddress(UserEntity user, AddressDTO addressDTO)
                                throws AddressExistsException, InvalidAddressNameException {
        if (addressRepository.existsByNameAndUserUsername(addressDTO.getName(), user.getUsername())) {
            throw new AddressExistsException(addressDTO.getName());
        }

        if (addressDTO.getName().length() > 25) {
            throw new InvalidAddressNameException();
        }

        Address address = AddressConversionUtil.convertToEntity(addressDTO);
        address.setUser(user);

        Address savedAddress = addressRepository.save(address);
        return AddressConversionUtil.convertToDTO(savedAddress);
    }

    @Transactional
    public void editAddress(UserEntity user, AddressDTO addressDTO)
                              throws AddressExistsException, InvalidAddressNameException {
        Address existingAddress = addressRepository.findByIdAndUserUsername(addressDTO.getId(), user.getUsername());
        if (existingAddress == null) {
            throw new AddressNotFoundException(addressDTO.getId());
        }

        if (addressDTO.getName().length() > 25) {
            throw new InvalidAddressNameException();
        }

        if (!existingAddress.getName().equals(addressDTO.getName()) &&
                addressRepository.existsByNameAndUserUsername(addressDTO.getName(), user.getUsername())) {
            throw new AddressExistsException(addressDTO.getName());
        }

        existingAddress.setName(addressDTO.getName());
        existingAddress.setAddressLine1(addressDTO.getAddressLine1());
        existingAddress.setAddressLine2(addressDTO.getAddressLine2());
        existingAddress.setCity(addressDTO.getCity());
        existingAddress.setCountry(addressDTO.getCountry());
        existingAddress.setZipcode(addressDTO.getZipcode());

        addressRepository.save(existingAddress);
    }

    // Doesn't delete the address from the database, but rather removes the association with the user.
    // The address is still needed for the order history of a registered user.
    @Transactional
    public void deleteAddress(UserEntity user, Long addressId) throws AddressNotFoundException {
        Address address = addressRepository.findByIdAndUserUsername(addressId, user.getUsername());
        if (address == null) {
            throw new AddressNotFoundException(addressId);
        }
        address.setUser(null);
    }

    public List<AddressDTO> getAndConvertAddresses(String username) {
        List<Address> addresses = addressRepository.findByUserEmail(username);
        logger.info("Fetched addresses: {}", addresses);
        return addresses.stream()
                .map(this::convertToDTO)
                .sorted(Comparator.comparing(AddressDTO::getId))
                .toList();
    }

    public Optional<Address> findById(Long addressId) {
        return addressRepository.findById(addressId);
    }
}