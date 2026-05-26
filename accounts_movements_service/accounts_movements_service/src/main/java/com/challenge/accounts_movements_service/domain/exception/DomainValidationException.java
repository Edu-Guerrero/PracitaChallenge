package com.challenge.accounts_movements_service.domain.exception;

public class DomainValidationException extends DomainException {
    public DomainValidationException(String message) {
        super(message);
    }
}
