package com.masmovil.controller;

import com.masmovil.domain.dto.ContactoDto;
import com.masmovil.service.ContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class ContactoController {

    private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);

    @Autowired
    ContactoService contactoService;

    @GetMapping("contact")
    public ContactoDto crearContacto(){
        return null;
    }

    @GetMapping("accounts/{accountId}/contact")
    public ContactoDto actualizarContacto(){
        return null;
    }

    @GetMapping("accounts/{accountId}/contact")
    public ContactoDto eliminarContacto(){
        return null;
    }
}
