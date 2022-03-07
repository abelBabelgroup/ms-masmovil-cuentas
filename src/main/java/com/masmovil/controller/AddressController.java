package com.masmovil.controller;

import com.masmovil.domain.dto.AddressDto;
import com.masmovil.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/accounts/{accountId}/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public AddressDto createAddress(@PathVariable Long accountId, @RequestBody AddressDto addressDto) {
        if (Objects.isNull(addressDto.getAddressId())) {
            addressDto.setAccountId(accountId);
            return addressService.save(addressDto);
        }
        // TODO: Gestionar los errores desde un handler
        throw new RuntimeException("Esa sede ya existe");
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable Long accountId, @PathVariable Long addressId) {
        addressService.delete(accountId, addressId);
    }

    @PutMapping("/{addressId}")
    public void updateAddress(@PathVariable Long accountId, @PathVariable Long addressId, @RequestBody AddressDto addressDto) {

        AddressDto addressDb = addressService.findById(addressId);
        if (Objects.isNull(addressDb)) {
            // TODO: Gestionar los errores desde un handler
            throw new RuntimeException("La sede que intenta modificar no existe");
        }
        addressDto.setAddressId(addressId);
        addressDto.setAccountId(accountId);
        addressService.save(addressDto);
    }
}
