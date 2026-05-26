package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class MovementNotFoundExceptionTest {

    @Test
    void shouldSetMessageWithMovementId() {
        UUID id = UUID.randomUUID();
        MovementNotFoundException ex = new MovementNotFoundException(id);
        assertEquals("Movement not found: " + id, ex.getMessage());
    }

    @Test
    void shouldSetCustomMessage() {
        String msg = "No existe el movimiento";
        MovementNotFoundException ex = new MovementNotFoundException(msg);
        assertEquals(msg, ex.getMessage());
    }
}
