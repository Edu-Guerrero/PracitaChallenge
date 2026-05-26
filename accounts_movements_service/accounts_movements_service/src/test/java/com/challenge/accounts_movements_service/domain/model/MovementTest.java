package com.challenge.accounts_movements_service.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    @Test
    void shouldBuildAndGetFields() {
        UUID id = UUID.randomUUID();
        UUID accId = UUID.randomUUID();
        LocalDate date = LocalDate.now();

        Movement mvt = Movement.builder()
                .id(id)
                .accountId(accId)
                .date(date)
                .type(MovementType.DEBIT)
                .value(BigDecimal.valueOf(123))
                .balanceAfter(BigDecimal.valueOf(10))
                .build();

        assertEquals(id, mvt.getId());
        assertEquals(accId, mvt.getAccountId());
        assertEquals(date, mvt.getDate());
        assertEquals(MovementType.DEBIT, mvt.getType());
        assertEquals(BigDecimal.valueOf(123), mvt.getValue());
        assertEquals(BigDecimal.valueOf(10), mvt.getBalanceAfter());
    }

    @Test
    void shouldSetAndGetWithSetters() {
        Movement mvt = new Movement();
        UUID id = UUID.randomUUID();
        mvt.setId(id);
        mvt.setAccountId(UUID.randomUUID());
        mvt.setDate(LocalDate.now());
        mvt.setType(MovementType.CREDIT);
        mvt.setValue(BigDecimal.valueOf(99));
        mvt.setBalanceAfter(BigDecimal.valueOf(77));

        assertEquals(id, mvt.getId());
        assertEquals(MovementType.CREDIT, mvt.getType());
        assertEquals(BigDecimal.valueOf(99), mvt.getValue());
        assertEquals(BigDecimal.valueOf(77), mvt.getBalanceAfter());
    }
}
