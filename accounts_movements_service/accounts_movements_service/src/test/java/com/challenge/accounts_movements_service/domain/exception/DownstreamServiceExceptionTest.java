package com.challenge.accounts_movements_service.domain.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DownstreamServiceExceptionTest {

    @Test
    void shouldSetMessage() {
        String msg = "Service unavailable";
        DownstreamServiceException ex = new DownstreamServiceException(msg);
        assertEquals(msg, ex.getMessage());
    }

    @Test
    void shouldSetMessageAndCause() {
        Throwable cause = new RuntimeException("fail");
        DownstreamServiceException ex = new DownstreamServiceException("fail msg", cause);
        assertEquals("fail msg", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
}
