package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DomainValidationExceptionTest {
    @Test
    void shouldSetCustomMessage() {
        String msg = "Field invalid";
        DomainValidationException ex = new DomainValidationException(msg);
        assertEquals(msg, ex.getMessage());
    }
}
