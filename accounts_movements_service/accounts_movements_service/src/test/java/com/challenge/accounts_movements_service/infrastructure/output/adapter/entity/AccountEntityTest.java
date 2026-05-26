package com.challenge.accounts_movements_service.infrastructure.output.adapter.entity;

import com.challenge.accounts_movements_service.domain.model.AccountType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountEntityTest {

    @Test
    void shouldBuildAndAccessAllFields() {
        UUID id = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        String accountNumber = "123456";
        BigDecimal initialBalance = BigDecimal.valueOf(1000);
        BigDecimal currentBalance = BigDecimal.valueOf(2100.50);
        AccountType type = AccountType.SAVINGS;

        AccountEntity acc = AccountEntity.builder()
                .id(id)
                .customerId(customerId)
                .accountNumber(accountNumber)
                .type(type)
                .initialBalance(initialBalance)
                .currentBalance(currentBalance)
                .status(true)
                .build();

        assertEquals(id, acc.getId());
        assertEquals(customerId, acc.getCustomerId());
        assertEquals(accountNumber, acc.getAccountNumber());
        assertEquals(type, acc.getType());
        assertEquals(initialBalance, acc.getInitialBalance());
        assertEquals(currentBalance, acc.getCurrentBalance());
        assertTrue(acc.isStatus());
    }

    @Test
    void shouldSetAndGetWithSetters() {
        AccountEntity acc = new AccountEntity();
        UUID id = UUID.randomUUID();
        acc.setId(id);
        acc.setCustomerId(UUID.randomUUID());
        acc.setAccountNumber("654321");
        acc.setType(AccountType.CHECKING);
        acc.setInitialBalance(BigDecimal.ZERO);
        acc.setCurrentBalance(BigDecimal.TEN);
        acc.setStatus(false);

        assertEquals(id, acc.getId());
        assertEquals(AccountType.CHECKING, acc.getType());
        assertEquals(BigDecimal.ZERO, acc.getInitialBalance());
        assertFalse(acc.isStatus());
    }
}
