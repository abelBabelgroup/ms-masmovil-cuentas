package com.masmovil.service;

import com.masmovil.domain.dto.AccountDto;
import com.masmovil.repository.AccountRepository;
import com.masmovil.repository.model.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<AccountDto> getAccounts(List<String> ownerId) {
        List<AccountDto> cuentasDto = new ArrayList<>();
        ownerId.forEach(id -> cuentasDto.addAll(accountRepository.findByOwnerId(id).stream().map(account -> modelMapper.map(account, AccountDto.class)).collect(Collectors.toList())));

        return cuentasDto;
    }

    @Transactional(readOnly = true)
    public List<AccountDto> getAccounts(List<String> ownerId, String name, String cif) {
        List<AccountDto> cuentasDto = new ArrayList<>();
        ownerId.forEach(id -> cuentasDto.addAll(accountRepository.findByOwnerIdAndNameOrCif(id, name, cif).stream().map(account -> modelMapper.map(account, AccountDto.class)).collect(Collectors.toList())));

        return cuentasDto;
    }

    @Transactional(readOnly = true)
    public AccountDto getAccountInfo(Long accountId) {
        Optional<Account> cuenta = accountRepository.findById(accountId);
        return cuenta.map(value -> modelMapper.map(value, AccountDto.class)).orElse(null);
    }
}
