package com.masmovil.service;

import com.masmovil.domain.dto.ContactDto;
import com.masmovil.repository.ContactRepository;
import com.masmovil.repository.entity.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContactDto createContact(Contact contact) {
        Optional<Contact> contact1 = contactRepository.create(contact);
        return contact1.map(value -> modelMapper.map(value, ContactDto.class)).orElseThrow();
    }

    public Optional<Contact> updateContact(Long contactId) {
        return contactRepository.update(contactId);
    }

    public Optional<Contact> deleteContact(Long contactId) {
        return contactRepository.delete(contactId);
    }
}
