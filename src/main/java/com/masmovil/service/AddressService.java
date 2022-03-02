package com.masmovil.service;

import com.masmovil.domain.dto.AddressDto;
import com.masmovil.repository.AddressRepository;
import com.masmovil.repository.entity.Address;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    private PropertyMap<AddressDto, Address> skipAddressesMap = new PropertyMap<>() {
        protected void configure() {
            //skip().getAccountId().setAddresses(null);
        }
    };

    @Transactional
    public AddressDto save(AddressDto addressDto) {
        //this.modelMapper.addMappings(skipAddressesMap);
        return modelMapper.map(addressRepository.save(modelMapper.map(addressDto, Address.class)), AddressDto.class);
    }

    @Transactional(readOnly = true)
    public AddressDto findById(Long id) {
        return modelMapper.map(addressRepository.findById(id), AddressDto.class);
    }

    @Transactional
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

}
