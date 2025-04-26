package com.example.patterns_banking.dtos;

import java.math.BigDecimal;

import com.example.patterns_banking.models.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String number;
    private AccountType type;
    private BigDecimal balance;
    private Boolean isActive;
}
