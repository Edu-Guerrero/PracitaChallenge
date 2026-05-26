package com.challenge.customer_service.domain.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DomainValidationExceptionTest {

    @Test
    void shouldUseProvidedMessage() {
        DomainValidationException ex = new DomainValidationException("invalid domain state");

        assertEquals("invalid domain state", ex.getMessage());
        assertNull(ex.getCause());
    }

    @Test
    void shouldUseProvidedMessageAndCause() {
        RuntimeException cause = new RuntimeException("root cause");

        DomainValidationException ex = new DomainValidationException("invalid domain state", cause);

        assertEquals("invalid domain state", ex.getMessage());
        assertSame(cause, ex.getCause());
    }
}
