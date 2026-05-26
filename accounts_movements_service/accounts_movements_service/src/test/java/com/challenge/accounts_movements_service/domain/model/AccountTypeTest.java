package com.challenge.accounts_movements_service.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTypeTest {

    @Test
    void shouldReturnEnumValues() {
        AccountType[] values = AccountType.values();
        assertEquals(2, values.length);
        assertEquals(AccountType.SAVINGS, AccountType.valueOf("SAVINGS"));
        assertEquals(AccountType.CHECKING, AccountType.valueOf("CHECKING"));
    }
}
