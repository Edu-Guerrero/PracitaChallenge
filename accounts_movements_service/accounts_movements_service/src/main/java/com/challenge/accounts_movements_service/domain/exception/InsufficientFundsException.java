package com.challenge.accounts_movements_service.domain.exception;

import static com.challenge.accounts_movements_service.domain.util.Constants.INSUFFICIENT_FUNDS;

public class InsufficientFundsException extends DomainException {

    public static final String DEFAULT_MESSAGE = INSUFFICIENT_FUNDS;

    public InsufficientFundsException() {
        super(DEFAULT_MESSAGE);
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
