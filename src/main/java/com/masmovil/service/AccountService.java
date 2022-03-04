package com.masmovil.service;

import com.masmovil.domain.dto.AccountDto;
import com.masmovil.repository.AccountRepository;
import com.masmovil.repository.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    public List<AccountDto> getAccounts(List<String> ownerId, String name, String cif) {
        List<AccountDto> accountsDto = new ArrayList<>();
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        ownerId.forEach(id ->{
            Example<Account> example = Example.of(new Account(id, name, cif), caseInsensitiveExampleMatcher);
            accountsDto.addAll(accountRepository.findAll(example).stream().map(account -> modelMapper.map(account, AccountDto.class)).collect(Collectors.toList()));
        });

        return accountsDto;
    }

    @Transactional(readOnly = true)
    public AccountDto getAccountInfo(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.map(value -> modelMapper.map(value, AccountDto.class)).orElse(null);
    }
}
