package com.masmovil.service;

import com.masmovil.repository.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaService {

    List<Cuenta> getAccounts(List<String> ownerId);
    List<Cuenta> getAccounts(List<String> ownerId, String name);
    List<Cuenta> getAccounts(List<String> ownerId, String name, String cif);

    Optional<Cuenta> getAccountInfo(Long accountId);
}
