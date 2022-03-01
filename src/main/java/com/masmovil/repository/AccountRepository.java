package com.masmovil.repository;

import com.masmovil.repository.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByOwnerId(String ownerId);

    List<Account> findByOwnerIdAndNameOrCif(String ownerId, String name, String cif);
}
