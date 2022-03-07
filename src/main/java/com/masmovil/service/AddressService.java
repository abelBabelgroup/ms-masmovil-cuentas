package com.masmovil.service;

import com.masmovil.domain.dto.AddressDto;
import com.masmovil.repository.AddressRepository;
import com.masmovil.repository.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public AddressDto save(AddressDto addressDto) {
        return modelMapper.map(addressRepository.save(modelMapper.map(addressDto, Address.class)), AddressDto.class);
    }

    @Transactional(readOnly = true)
    public AddressDto findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.map(value -> modelMapper.map(value, AddressDto.class)).orElse(null);
    }

    @Transactional
    public void delete(Long accountId, Long addressId) {
        addressRepository.deleteByAccountIdAndAddressId(accountId, addressId);
    }

}
