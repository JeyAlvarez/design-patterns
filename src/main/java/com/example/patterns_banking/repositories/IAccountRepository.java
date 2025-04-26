package com.example.patterns_banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.patterns_banking.models.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}

