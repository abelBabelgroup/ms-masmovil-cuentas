package com.masmovil.service;

import com.masmovil.domain.dto.ContactDto;
import com.masmovil.repository.ContactRepository;
import com.masmovil.repository.entity.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact = modelMapper.map(contactDto, Contact.class);
        return modelMapper.map(contactRepository.save(contact), ContactDto.class);
    }

    @Transactional
    public ContactDto updateContact(Long contactId, ContactDto contactDto) {
        contactRepository.findByContactId(contactId);
        Contact contactEntity = modelMapper.map(contactDto, Contact.class);
        return modelMapper.map(contactRepository.save(contactEntity), ContactDto.class);
    }

    @Transactional
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }
}
