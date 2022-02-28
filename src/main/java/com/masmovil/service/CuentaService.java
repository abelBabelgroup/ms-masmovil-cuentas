package com.masmovil.service;

import com.masmovil.domain.dto.CuentaDto;
import com.masmovil.repository.CuentaRepository;
import com.masmovil.repository.model.Cuenta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<CuentaDto> getAccounts(List<String> ownerId) {
        List<CuentaDto> cuentasDto = new ArrayList<>();
        ownerId.forEach(id -> cuentasDto.addAll(cuentaRepository.findByIdPropietario(id).stream().map(cuenta -> modelMapper.map(cuenta, CuentaDto.class)).collect(Collectors.toList())));

        return cuentasDto;
    }

    @Transactional(readOnly = true)
    public List<CuentaDto> getAccounts(List<String> ownerId, String name, String cif) {
        List<CuentaDto> cuentasDto = new ArrayList<>();
        ownerId.forEach(id -> cuentasDto.addAll(cuentaRepository.findByIdPropietarioAndNombreOrCif(id, name, cif).stream().map(cuenta -> modelMapper.map(cuenta, CuentaDto.class)).collect(Collectors.toList())));

        return cuentasDto;
    }

    @Transactional(readOnly = true)
    public CuentaDto getAccountInfo(Long accountId) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(accountId);
        return cuenta.map(value -> modelMapper.map(value, CuentaDto.class)).orElse(null);
    }
}
