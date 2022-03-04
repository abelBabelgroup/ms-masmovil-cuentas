package com.masmovil.controller;

import com.masmovil.domain.dto.BankAccountDto;
import com.masmovil.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/accounts/{accountId}/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccountDto> getBankAccounts(@PathVariable Long accountId) {
        return bankAccountService.findAllBankAccountsByAccountId(accountId);
    }

    @PostMapping
    public BankAccountDto addBankAccount(@PathVariable Long accountId, @RequestBody BankAccountDto bankAccountDto) {
        if (Objects.isNull(bankAccountDto.getBankAccountId())) {
            bankAccountDto.setAccountId(accountId);
            return bankAccountService.save(bankAccountDto);
        }
        // TODO: Gestionar los errores desde un handler
        throw new RuntimeException("Esa cuenta bancaria ya existe");
    }

    @PutMapping("/{bankAccountId}")
    public void updateBankAccount(@PathVariable Long accountId, @PathVariable Long bankAccountId, @RequestBody BankAccountDto bankAccountDto) {
        BankAccountDto bankAccountDb = bankAccountService.findById(bankAccountId);
        if (Objects.isNull(bankAccountDb)) {
            // TODO: Gestionar los errores desde un handler
            throw new RuntimeException("La cuenta bancaria que intenta modificar no existe");
        }
        bankAccountDto.setBankAccountId(bankAccountId);
        bankAccountDto.setAccountId(accountId);
        bankAccountService.save(bankAccountDto);
    }

    @DeleteMapping("/{bankAccountId}")
    public void deleteBankAccount(@PathVariable Long accountId, @PathVariable Long bankAccountId) {
        bankAccountService.delete(bankAccountId);
    }

}
