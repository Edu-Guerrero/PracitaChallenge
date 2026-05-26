package com.challenge.customer_service.domain.exception;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class CustomerNotFoundExceptionTest {

    @Test
    void shouldBuildMessageFromCustomerId() {
        UUID id = UUID.fromString("11111111-1111-1111-1111-111111111111");

        CustomerNotFoundException ex = new CustomerNotFoundException(id);

        assertEquals("Customer not found: " + id, ex.getMessage());
        assertNull(ex.getCause());
    }

    @Test
    void shouldUseProvidedMessage() {
        CustomerNotFoundException ex = new CustomerNotFoundException("custom message");

        assertEquals("custom message", ex.getMessage());
        assertNull(ex.getCause());
    }
}
