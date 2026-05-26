package com.challenge.accounts_movements_service.domain.exception;

import java.util.UUID;

public class AccountNotFoundException extends DomainException {

    public AccountNotFoundException(UUID accountId) {
        super("Account not found: " + accountId);
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
