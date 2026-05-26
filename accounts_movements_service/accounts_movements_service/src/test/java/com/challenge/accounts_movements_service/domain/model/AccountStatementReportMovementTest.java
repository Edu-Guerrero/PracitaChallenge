package com.challenge.accounts_movements_service.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountStatementReportMovementTest {

    @Test
    void shouldBuildAndGetFields() {
        UUID id = UUID.randomUUID();
        LocalDate date = LocalDate.now();
        AccountStatementReportMovement mvt = AccountStatementReportMovement.builder()
                .movementId(id)
                .date(date)
                .type(MovementType.CREDIT)
                .value(BigDecimal.valueOf(500))
                .balanceAfter(BigDecimal.valueOf(700))
                .build();

        assertEquals(id, mvt.getMovementId());
        assertEquals(date, mvt.getDate());
        assertEquals(MovementType.CREDIT, mvt.getType());
        assertEquals(BigDecimal.valueOf(500), mvt.getValue());
        assertEquals(BigDecimal.valueOf(700), mvt.getBalanceAfter());
    }

    @Test
    void shouldWorkWithAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        LocalDate date = LocalDate.now();
        AccountStatementReportMovement mvt = new AccountStatementReportMovement(
                id, date, MovementType.DEBIT, BigDecimal.ONE, BigDecimal.TEN
        );
        assertEquals(id, mvt.getMovementId());
        assertEquals(date, mvt.getDate());
        assertEquals(MovementType.DEBIT, mvt.getType());
        assertEquals(BigDecimal.ONE, mvt.getValue());
        assertEquals(BigDecimal.TEN, mvt.getBalanceAfter());
    }
}
