package com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.AccountEntity;

public class AccountJpaMapper {

    private AccountJpaMapper() {}

    public static AccountEntity toEntity(Account d) {
        if (d == null) return null;

        return AccountEntity.builder()
                .id(d.getId())
                .customerId(d.getCustomerId())
                .accountNumber(d.getAccountNumber())
                .type(d.getType())
                .initialBalance(d.getInitialBalance())
                .currentBalance(d.getCurrentBalance())
                .status(d.isStatus())
                .build();
    }

    public static Account toDomain(AccountEntity e) {
        if (e == null) return null;

        return Account.builder()
                .id(e.getId())
                .customerId(e.getCustomerId())
                .accountNumber(e.getAccountNumber())
                .type(e.getType())
                .initialBalance(e.getInitialBalance())
                .currentBalance(e.getCurrentBalance())
                .status(e.isStatus())
                .build();
    }

    public static void applyToExistingEntity(Account d, AccountEntity e) {
        e.setCustomerId(d.getCustomerId());
        e.setAccountNumber(d.getAccountNumber());
        e.setType(d.getType());
        e.setInitialBalance(d.getInitialBalance());
        e.setCurrentBalance(d.getCurrentBalance());
        e.setStatus(d.isStatus());
    }
}
