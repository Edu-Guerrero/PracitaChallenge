package com.challenge.accounts_movements_service.domain.exception;

public class DuplicatedAccountNumberException extends DomainException {

    public DuplicatedAccountNumberException(String accountNumber) {
        super("Account number already exists: " + accountNumber);
    }
}
