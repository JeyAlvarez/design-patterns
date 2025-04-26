package com.example.patterns_banking.models;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private BigDecimal balance;

    private Boolean isActive = true;

    // Constructor con argumentos (opcional)
    public Account(Long id, String number, AccountType type, BigDecimal balance, Boolean isActive) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.isActive = isActive;
    }

    // Constructor que acepta un objeto Builder
    private Account(Builder builder) {
        this.id = builder.id;
        this.number = builder.number;
        this.type = builder.type;
        this.balance = builder.balance;
        this.isActive = builder.isActive;
    }

    // Getters y setters (si no usas Lombok)


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String number;
        private AccountType type;
        private BigDecimal balance;
        private Boolean isActive = true;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder type(AccountType type) {
            this.type = type;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El valor del depósito debe ser mayor que cero.");
        }
        this.balance = this.balance.add(amount);
    }
}
