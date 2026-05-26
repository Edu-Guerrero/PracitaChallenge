package com.challenge.accounts_movements_service.infrastructure.output.adapter.entity;

import com.challenge.accounts_movements_service.domain.model.MovementType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MovementEntityTest {

    @Test
    void shouldBuildAndAccessAllFields() {
        UUID id = UUID.randomUUID();
        UUID accountId = UUID.randomUUID();
        LocalDate date = LocalDate.of(2024, 5, 20);
        MovementType type = MovementType.DEBIT;
        BigDecimal value = BigDecimal.valueOf(200.75);
        BigDecimal balanceAfter = BigDecimal.valueOf(999.25);

        MovementEntity movement = MovementEntity.builder()
                .id(id)
                .accountId(accountId)
                .date(date)
                .type(type)
                .value(value)
                .balanceAfter(balanceAfter)
                .build();

        assertEquals(id, movement.getId());
        assertEquals(accountId, movement.getAccountId());
        assertEquals(date, movement.getDate());
        assertEquals(type, movement.getType());
        assertEquals(value, movement.getValue());
        assertEquals(balanceAfter, movement.getBalanceAfter());
    }

    @Test
    void shouldSetAndGetWithSetters() {
        MovementEntity movement = new MovementEntity();
        UUID id = UUID.randomUUID();
        movement.setId(id);
        movement.setAccountId(UUID.randomUUID());
        movement.setDate(LocalDate.now());
        movement.setType(MovementType.CREDIT);
        movement.setValue(BigDecimal.ONE);
        movement.setBalanceAfter(BigDecimal.TEN);

        assertEquals(id, movement.getId());
        assertEquals(MovementType.CREDIT, movement.getType());
        assertEquals(BigDecimal.ONE, movement.getValue());
        assertEquals(BigDecimal.TEN, movement.getBalanceAfter());
    }
}
