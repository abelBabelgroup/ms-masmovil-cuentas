package com.masmovil.controller;

import com.masmovil.domain.dto.ContactDto;
import com.masmovil.repository.entity.Contact;
import com.masmovil.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @PostMapping("")
    public ResponseEntity<ContactDto> createContact(@Valid @RequestBody Contact contact) {
        ContactDto contactDto1 = contactService.createContact(contact);
        return ResponseEntity.ok(contactDto1);
    }

    @PutMapping("accounts/{accountId}/contact")
    public ResponseEntity<ContactDto> updateContact(@RequestParam Long accountId) {
        contactService.updateContact(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("accounts/{accountId}/contact")
    public ResponseEntity<Void> deleteContact(@RequestParam Long accountId) {
        contactService.deleteContact(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
