package com.challenge.accounts_movements_service.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTypeTest {

    @Test
    void shouldReturnEnumValues() {
        MovementType[] values = MovementType.values();
        assertEquals(2, values.length);
        assertEquals(MovementType.DEBIT, MovementType.valueOf("DEBIT"));
        assertEquals(MovementType.CREDIT, MovementType.valueOf("CREDIT"));
    }
}
