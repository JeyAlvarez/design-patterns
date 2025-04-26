package com.example.patterns_banking.services;

import org.springframework.stereotype.Service;

import com.example.patterns_banking.dtos.AccountDTO;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.repositories.AccountRepository;

@Service
public class AccountService {

    // Assuming you have an AccountRepository to handle database operations
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository.getInstance();
    }

    public Account create(AccountDTO accountDTO) {
        Account account = new Account().builder()
        .number(accountDTO.getNumber())
        .type(accountDTO.getType())
        .balance(accountDTO.getBalance())
        .isActive(true) // Assuming new accounts are active by default
        .build();
        // Set other properties as needed

        return accountRepository.save(account);
    }
}
