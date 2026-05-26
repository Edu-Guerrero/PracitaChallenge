package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class AccountNotFoundExceptionTest {

    @Test
    void shouldSetMessageWithAccountId() {
        UUID uuid = UUID.randomUUID();
        AccountNotFoundException ex = new AccountNotFoundException(uuid);
        assertEquals("Account not found: " + uuid, ex.getMessage());
    }

    @Test
    void shouldSetCustomMessage() {
        String msg = "Account not present";
        AccountNotFoundException ex = new AccountNotFoundException(msg);
        assertEquals(msg, ex.getMessage());
    }
}
