package com.challenge.accounts_movements_service.domain.exception;

import java.util.UUID;

public class AccountInactiveException extends DomainException {

    public AccountInactiveException(UUID accountId) {
        super("Account is inactive: " + accountId);
    }

    public AccountInactiveException(String message) {
        super(message);
    }
}
