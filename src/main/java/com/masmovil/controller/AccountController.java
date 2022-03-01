package com.masmovil.controller;

import com.masmovil.domain.dto.AccountDto;
import com.masmovil.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts(@RequestParam List<String> ownerId, @RequestParam(required = false) String name, @RequestParam(required = false) String cif) {
        List<AccountDto> accountsDto;
        if (Objects.isNull(name) && Objects.isNull(cif)) {
            accountsDto = accountService.getAccounts(ownerId);
            return ResponseEntity.ok(accountsDto);
        }
        accountsDto = accountService.getAccounts(ownerId, name, cif);
        return ResponseEntity.ok(accountsDto);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long accountId ) {
        AccountDto accountDto = accountService.getAccountInfo(accountId);
        if (Objects.isNull(accountDto)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDto);
    }
}
