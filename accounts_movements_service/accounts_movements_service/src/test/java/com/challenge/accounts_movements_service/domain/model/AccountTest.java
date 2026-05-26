package com.challenge.accounts_movements_service.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void shouldCreateAccountUsingBuilderAndAccessFields() {
        UUID id = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        String accNum = "ACC123";
        Account account = Account.builder()
                .id(id)
                .customerId(customerId)
                .accountNumber(accNum)
                .type(AccountType.SAVINGS)
                .initialBalance(BigDecimal.valueOf(500))
                .currentBalance(BigDecimal.valueOf(800))
                .status(true)
                .build();

        assertEquals(id, account.getId());
        assertEquals(customerId, account.getCustomerId());
        assertEquals(accNum, account.getAccountNumber());
        assertEquals(AccountType.SAVINGS, account.getType());
        assertEquals(BigDecimal.valueOf(500), account.getInitialBalance());
        assertEquals(BigDecimal.valueOf(800), account.getCurrentBalance());
        assertTrue(account.isStatus());
    }

    // Lombok @Setter/@Getter should work
    @Test
    void shouldSetAndGetFields() {
        Account account = new Account();
        account.setId(UUID.randomUUID());
        account.setCustomerId(UUID.randomUUID());
        account.setAccountNumber("ACC456");
        account.setType(AccountType.CHECKING);
        account.setInitialBalance(BigDecimal.valueOf(0));
        account.setCurrentBalance(BigDecimal.valueOf(1000));
        account.setStatus(false);

        assertNotNull(account.getId());
        assertNotNull(account.getCustomerId());
        assertEquals("ACC456", account.getAccountNumber());
        assertEquals(AccountType.CHECKING, account.getType());
        assertEquals(BigDecimal.valueOf(0), account.getInitialBalance());
        assertEquals(BigDecimal.valueOf(1000), account.getCurrentBalance());
        assertFalse(account.isStatus());
    }
}
