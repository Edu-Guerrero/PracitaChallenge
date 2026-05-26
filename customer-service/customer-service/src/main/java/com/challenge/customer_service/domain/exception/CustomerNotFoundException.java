package com.challenge.customer_service.domain.exception;

import java.util.UUID;

import static com.challenge.customer_service.domain.util.Constants.CUSTOMER_NOT_FOUND;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(UUID customerId) {
        super(CUSTOMER_NOT_FOUND + customerId);
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
