package com.challenge.accounts_movements_service.domain.exception;

public class DownstreamServiceException extends DomainException {

    public DownstreamServiceException(String message) {
        super(message);
    }

    public DownstreamServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
