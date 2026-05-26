package com.challenge.accounts_movements_service.domain.exception;

public class InsufficientFundsException extends DomainException {

    public static final String DEFAULT_MESSAGE = "Saldo no disponible";

    public InsufficientFundsException() {
        super(DEFAULT_MESSAGE);
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
