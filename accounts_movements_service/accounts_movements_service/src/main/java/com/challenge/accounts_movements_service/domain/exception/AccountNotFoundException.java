package com.challenge.accounts_movements_service.domain.exception;

import java.util.UUID;

import static com.challenge.accounts_movements_service.domain.util.Constants.ACCOUNT_NOT_FOUND;

public class AccountNotFoundException extends DomainException {

    public AccountNotFoundException(UUID accountId) {
        super(ACCOUNT_NOT_FOUND + accountId);
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
