package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsufficientFundsExceptionTest {

    @Test
    void shouldUseDefaultMessage() {
        InsufficientFundsException ex = new InsufficientFundsException();
        assertEquals("Saldo no disponible", ex.getMessage());
    }

    @Test
    void shouldUseCustomMessage() {
        String msg = "Sin fondos";
        InsufficientFundsException ex = new InsufficientFundsException(msg);
        assertEquals(msg, ex.getMessage());
    }
}
