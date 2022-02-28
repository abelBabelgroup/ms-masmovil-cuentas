package com.masmovil.controller;

import com.masmovil.domain.dto.CuentaDto;
import com.masmovil.repository.model.Cuenta;
import com.masmovil.service.CuentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CuentaDto>> getAccounts(@RequestParam List<String> ownerId, @RequestParam(required = false) String name, @RequestParam(required = false) String cif) {

        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<CuentaDto> getAccount(@PathVariable Long accountId ) {

        Optional<Cuenta> optionalCuenta = cuentaService.getAccountInfo(accountId);
        if (optionalCuenta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CuentaDto cuentaDto = modelMapper.map(optionalCuenta.get(), CuentaDto.class);

        return ResponseEntity.ok(cuentaDto);
    }
}
