package com.masmovil.controller;

import com.masmovil.repository.model.Sede;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @PostMapping
    public Sede createAddress(@RequestParam Sede address) {

        return new Sede();
    }

}
