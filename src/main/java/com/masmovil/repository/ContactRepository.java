package com.masmovil.repository;

import com.masmovil.repository.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact save(Contact contact);
//    Contact update(Long contactId);
//    Contact delete(Long contactId);
}
