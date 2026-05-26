package com.challenge.customer_service.domain.exception;

import static com.challenge.customer_service.domain.util.Constants.CUSTOMER_ID_DUPLICATED;

public class DuplicatedIdentificationException extends RuntimeException {
    public DuplicatedIdentificationException(String identification) {
        super(CUSTOMER_ID_DUPLICATED + identification);
    }

    public DuplicatedIdentificationException(String identification, Throwable cause) {
        super(CUSTOMER_ID_DUPLICATED + identification, cause);
    }
}
