package com.masmovil.controller;

import com.masmovil.domain.dto.ContactDto;
import com.masmovil.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("")
    public ResponseEntity<ContactDto> createContact(@Valid @RequestBody ContactDto contactDto) {
        ContactDto contactDto1 = contactService.createContact(contactDto);
        return ResponseEntity.ok(contactDto1);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<Void> updateContact(@PathVariable Long contactId,
        @RequestBody ContactDto contactDto) {
        contactService.updateContact(contactId, contactDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
