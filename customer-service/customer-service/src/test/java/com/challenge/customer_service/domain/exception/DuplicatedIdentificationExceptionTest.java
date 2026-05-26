package com.challenge.customer_service.domain.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DuplicatedIdentificationExceptionTest {

    @Test
    void shouldBuildMessageFromIdentification() {
        DuplicatedIdentificationException ex = new DuplicatedIdentificationException("ABC123");

        assertEquals("Customer with same identification already exists: ABC123", ex.getMessage());
        assertNull(ex.getCause());
    }

    @Test
    void shouldBuildMessageFromIdentificationAndCause() {
        RuntimeException cause = new RuntimeException("db constraint");
        DuplicatedIdentificationException ex = new DuplicatedIdentificationException("ABC123", cause);

        assertEquals("Customer with same identification already exists: ABC123", ex.getMessage());
        assertSame(cause, ex.getCause());
    }
}
