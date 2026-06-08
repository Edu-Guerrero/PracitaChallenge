package com.challenge.accounts_movements_service.domain.exception;

import java.util.UUID;

import static com.challenge.accounts_movements_service.domain.util.Constants.ACCOUNT_INACTIVE_WITH_ID;

public class AccountInactiveException extends DomainException {

    public AccountInactiveException(UUID accountId) {
        super(ACCOUNT_INACTIVE_WITH_ID + accountId);
    }

    public AccountInactiveException(String message) {
        super(message);
    }
}
