package com.masmovil.controller;

import com.masmovil.domain.dto.ContactDto;
import com.masmovil.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/account/{accountId}/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactDto createContact(@PathVariable Long accountId, @Valid @RequestBody ContactDto contactDto) {

        if (Objects.isNull(contactDto.getContactId())) {
            contactDto.setAccountId(accountId);
            return contactService.save(contactDto);
        }
        // TODO: Gestionar los errores desde un handler
        throw new RuntimeException("Ese contacto ya existe");
    }

    @PutMapping("/{contactId}")
    public void updateContact(@PathVariable Long accountId, @PathVariable Long contactId, @RequestBody ContactDto contactDto) {
        ContactDto contactoDb = contactService.findById(contactId);
        if (Objects.isNull(contactoDb)) {
            // TODO: Gestionar los errores desde un handler
            throw new RuntimeException("El contacto que intenta modificar no existe");
        }
        contactDto.setAccountId(accountId);
        contactDto.setContactId(contactId);
        contactService.save(contactDto);
    }

    @DeleteMapping("/{contactId}")
    public void deleteContact(@PathVariable Long accountId, @PathVariable Long contactId) {
        contactService.deleteContact(accountId, contactId);
    }
}
