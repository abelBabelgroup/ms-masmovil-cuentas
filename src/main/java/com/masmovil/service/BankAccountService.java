package com.masmovil.service;

import com.masmovil.domain.dto.BankAccountDto;
import com.masmovil.repository.BankAccountRepository;
import com.masmovil.repository.entity.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public BankAccountDto save(BankAccountDto bankAccountDto) {
        return modelMapper.map(bankAccountRepository.save(modelMapper.map(bankAccountDto, BankAccount.class)), BankAccountDto.class);
    }

    @Transactional(readOnly = true)
    public List<BankAccountDto> findAllBankAccountsByAccountId(Long id) {
        return bankAccountRepository.findAllByAccountId(id).stream().map(bankAccount -> modelMapper.map(bankAccount, BankAccountDto.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BankAccountDto findById(Long id) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        return bankAccount.map(value -> modelMapper.map(value, BankAccountDto.class)).orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        bankAccountRepository.deleteById(id);
    }

}
