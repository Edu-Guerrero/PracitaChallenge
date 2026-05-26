package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class CustomerNotFoundExceptionTest {

    @Test
    void shouldSetMessageWithCustomerId() {
        UUID uuid = UUID.randomUUID();
        CustomerNotFoundException ex = new CustomerNotFoundException(uuid);
        assertEquals("Customer not found: " + uuid, ex.getMessage());
    }
}
