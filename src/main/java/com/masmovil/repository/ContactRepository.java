package com.masmovil.repository;

import com.masmovil.repository.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> create(Contact contact);
    Optional<Contact> update(Long accountId);
    Optional<Contact> delete(Long accountId);
}
