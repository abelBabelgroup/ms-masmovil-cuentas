package com.masmovil.controller;

import com.masmovil.domain.dto.CuentaDto;
import com.masmovil.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/accounts")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<CuentaDto>> getAccounts(@RequestParam List<String> ownerId, @RequestParam(required = false) String name, @RequestParam(required = false) String cif) {

        List<CuentaDto> cuentasDto;
        if (Objects.isNull(name) && Objects.isNull(cif)) {
            cuentasDto = cuentaService.getAccounts(ownerId);

            return ResponseEntity.ok(cuentasDto);
        }

        cuentasDto = cuentaService.getAccounts(ownerId, name, cif);

        return ResponseEntity.ok(cuentasDto);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<CuentaDto> getAccount(@PathVariable Long accountId ) {

        CuentaDto cuentaDto = cuentaService.getAccountInfo(accountId);
        if (Objects.isNull(cuentaDto)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cuentaDto);
    }
}
