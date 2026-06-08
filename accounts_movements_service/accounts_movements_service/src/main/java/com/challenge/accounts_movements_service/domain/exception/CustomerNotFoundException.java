package com.challenge.accounts_movements_service.domain.exception;

import java.util.UUID;

import static com.challenge.accounts_movements_service.domain.util.Constants.CUSTOMER_NOT_FOUND;

public class CustomerNotFoundException extends DomainException {

    public CustomerNotFoundException(UUID customerId) {
        super(CUSTOMER_NOT_FOUND + customerId);
    }
}
