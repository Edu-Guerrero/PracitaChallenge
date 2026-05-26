package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DomainExceptionTest {
    static class DummyDomainException extends DomainException {
        DummyDomainException(String msg) { super(msg); }
        DummyDomainException(String msg, Throwable cause) { super(msg, cause); }
    }

    @Test
    void shouldSetMessage() {
        DummyDomainException ex = new DummyDomainException("test");
        assertEquals("test", ex.getMessage());
    }

    @Test
    void shouldSetMessageAndCause() {
        Throwable cause = new RuntimeException("root");
        DummyDomainException ex = new DummyDomainException("msg", cause);
        assertEquals("msg", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
}
