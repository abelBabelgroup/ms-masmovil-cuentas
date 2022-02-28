package com.masmovil.service.impl;

import com.masmovil.repository.CuentaRepository;
import com.masmovil.repository.model.Cuenta;
import com.masmovil.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cuenta> getAccounts(List<String> ownerId) {
        List<Cuenta> cuentas = new ArrayList<>();
        ownerId.forEach(id -> cuentas.addAll(cuentaRepository.findByIdPropietario(id)));

        return cuentas;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cuenta> getAccounts(List<String> ownerId, String name, String cif) {
        List<Cuenta> cuentas = new ArrayList<>();
        //ownerId.forEach(id -> cuentas.addAll(cuentaRepository.findByIdPropietarioAndNombreOrCif(id, name, cif)));
        ownerId.forEach(id -> cuentas.addAll(cuentaRepository.findByIdPropietarioEqualsAndNombreEqualsOrCifEquals(id, name, cif)));

        return cuentas;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cuenta> getAccountInfo(Long accountId) {
        return cuentaRepository.findById(accountId);
    }
}
