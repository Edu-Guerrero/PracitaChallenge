package com.challenge.accounts_movements_service.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountStatementReportAccountTest {

    @Test
    void shouldBuildAccountWithMovementsList() {
        UUID accId = UUID.randomUUID();

        AccountStatementReportMovement movement = AccountStatementReportMovement.builder()
                .movementId(UUID.randomUUID())
                .build();

        AccountStatementReportAccount acc = AccountStatementReportAccount.builder()
                .accountId(accId)
                .accountNumber("ACC002")
                .type(AccountType.CHECKING)
                .initialBalance(BigDecimal.TEN)
                .currentBalance(BigDecimal.ONE)
                .movement(movement) // using @Singular
                .build();

        assertEquals(accId, acc.getAccountId());
        assertEquals("ACC002", acc.getAccountNumber());
        assertEquals(AccountType.CHECKING, acc.getType());
        assertEquals(BigDecimal.TEN, acc.getInitialBalance());
        assertEquals(BigDecimal.ONE, acc.getCurrentBalance());
        assertEquals(1, acc.getMovements().size());
        assertEquals(movement, acc.getMovements().get(0));
    }

    @Test
    void shouldWorkWithAllArgsConstructor() {
        UUID accId = UUID.randomUUID();
        AccountStatementReportAccount acc = new AccountStatementReportAccount(
                accId, "ACC100",
                AccountType.SAVINGS,
                BigDecimal.ONE, BigDecimal.TEN,
                Collections.emptyList()
        );
        assertEquals(accId, acc.getAccountId());
        assertEquals("ACC100", acc.getAccountNumber());
        assertEquals(AccountType.SAVINGS, acc.getType());
        assertEquals(BigDecimal.ONE, acc.getInitialBalance());
        assertEquals(BigDecimal.TEN, acc.getCurrentBalance());
        assertTrue(acc.getMovements().isEmpty());
    }
}
