package com.masmovil.controller;

import com.masmovil.domain.dto.AccountDto;
import com.masmovil.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountDto> getAccounts(@RequestParam List<String> ownerId, @RequestParam(required = false) String name, @RequestParam(required = false) String cif) {
        List<AccountDto> accountsDto;
        if (Objects.isNull(name) && Objects.isNull(cif)) {
            accountsDto = accountService.getAccounts(ownerId);
            return accountsDto;
        }
        accountsDto = accountService.getAccounts(ownerId, name, cif);
        return accountsDto;
    }

    @GetMapping("/{accountId}")
    public AccountDto getAccount(@PathVariable Long accountId ) throws AccountNotFoundException {
        AccountDto accountDto = accountService.getAccountInfo(accountId);
        if (Objects.isNull(accountDto)) {
            // Devolver error personalizado y gestionarlo en un handler
            throw new AccountNotFoundException("La cuenta que buscas no existe");
        }
        return accountDto;
    }
}
