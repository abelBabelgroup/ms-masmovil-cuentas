package com.masmovil.controller;

import com.masmovil.domain.dto.ContactDto;
import com.masmovil.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactDto createContact(@Valid @RequestBody ContactDto contactDto) {

        if (Objects.isNull(contactDto.getContactId())) {
            return contactService.save(contactDto);
        }
        // TODO: Gestionar los errores desde un handler
        throw new RuntimeException("Ese contacto ya existe");
    }

    @PutMapping("/{contactId}")
    public void updateContact(@PathVariable Long contactId, @RequestBody ContactDto contactDto) {
        ContactDto contactoDb = contactService.findById(contactId);
        if (Objects.isNull(contactoDb)) {
            // TODO: Gestionar los errores desde un handler
            throw new RuntimeException("El contacto que intenta modificar no existe");
        }
        contactDto.setContactId(contactId);
        contactService.save(contactDto);
    }

    @DeleteMapping("/{contactId}")
    public void deleteContact(@PathVariable Long contactId) {
        contactService.deleteContact(contactId);
    }
}
