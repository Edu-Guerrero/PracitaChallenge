package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DuplicatedAccountNumberExceptionTest {

    @Test
    void shouldSetMessageWithAccountNumber() {
        String number = "ACC001";
        DuplicatedAccountNumberException ex = new DuplicatedAccountNumberException(number);
        assertEquals("Account number already exists: " + number, ex.getMessage());
    }
}
