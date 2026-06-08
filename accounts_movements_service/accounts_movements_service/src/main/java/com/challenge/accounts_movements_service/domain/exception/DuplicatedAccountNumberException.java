package com.challenge.accounts_movements_service.domain.exception;

import static com.challenge.accounts_movements_service.domain.util.Constants.ACCOUNT_NUMBER_DUPLICATED;

public class DuplicatedAccountNumberException extends DomainException {

    public DuplicatedAccountNumberException(String accountNumber) {
        super(ACCOUNT_NUMBER_DUPLICATED + accountNumber);
    }
}
