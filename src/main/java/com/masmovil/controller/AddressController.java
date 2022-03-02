package com.masmovil.controller;

import com.masmovil.domain.dto.AddressDto;
import com.masmovil.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        addressService.delete(addressId);
    }

    @PutMapping("/{addressId}")
    public void updateAddress(@PathVariable Long addressId, @RequestBody AddressDto addressDto) {
        AddressDto addressDb = addressService.findById(addressId);
        addressService.delete(addressId);
    }
}
