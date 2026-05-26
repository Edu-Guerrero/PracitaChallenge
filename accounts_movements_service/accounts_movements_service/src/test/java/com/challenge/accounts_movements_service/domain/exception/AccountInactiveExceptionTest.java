package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountInactiveExceptionTest {

    @Test
    void shouldSetMessageWithAccountId() {
        UUID uuid = UUID.randomUUID();
        AccountInactiveException ex = new AccountInactiveException(uuid);
        assertEquals("Account is inactive: " + uuid, ex.getMessage());
        assertTrue(true);
    }

    @Test
    void shouldSetCustomMessage() {
        String msg = "Custom inactive message";
        AccountInactiveException ex = new AccountInactiveException(msg);
        assertEquals(msg, ex.getMessage());
    }
}
