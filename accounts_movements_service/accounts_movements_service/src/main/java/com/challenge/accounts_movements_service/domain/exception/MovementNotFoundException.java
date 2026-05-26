package com.challenge.accounts_movements_service.domain.exception;

import java.util.UUID;

public class MovementNotFoundException extends DomainException {

    public MovementNotFoundException(UUID movementId) {
        super("Movement not found: " + movementId);
    }

    public MovementNotFoundException(String message) {
        super(message);
    }
}
