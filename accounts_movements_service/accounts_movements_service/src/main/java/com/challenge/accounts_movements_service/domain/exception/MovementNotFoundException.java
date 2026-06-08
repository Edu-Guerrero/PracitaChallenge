package com.challenge.accounts_movements_service.domain.exception;

import java.util.UUID;

import static com.challenge.accounts_movements_service.domain.util.Constants.MOVEMENT_NOT_FOUND;

public class MovementNotFoundException extends DomainException {

    public MovementNotFoundException(UUID movementId) {
        super(MOVEMENT_NOT_FOUND + movementId);
    }

    public MovementNotFoundException(String message) {
        super(message);
    }
}
