package com.masmovil.service;

import com.masmovil.domain.dto.ContactDto;
import com.masmovil.repository.ContactRepository;
import com.masmovil.repository.entity.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ContactDto save(ContactDto contactDto) {
        Contact contact = modelMapper.map(contactDto, Contact.class);
        return modelMapper.map(contactRepository.save(contact), ContactDto.class);
    }

    @Transactional(readOnly = true)
    public ContactDto findById(Long contactId) {
        Optional<Contact> contact = contactRepository.findById(contactId);
        return contact.map(value -> modelMapper.map(value, ContactDto.class)).orElse(null);
    }

    @Transactional
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }
}
