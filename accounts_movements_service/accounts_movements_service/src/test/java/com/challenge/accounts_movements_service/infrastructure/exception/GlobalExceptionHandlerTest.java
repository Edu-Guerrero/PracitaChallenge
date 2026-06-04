package com.challenge.accounts_movements_service.infrastructure.exception;

import com.challenge.accounts_movements_service.domain.exception.*;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.ApiError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;
    private ServerWebExchange exchange;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
        exchange = mock(ServerWebExchange.class);

        ServerHttpRequest request = mock(ServerHttpRequest.class);
        RequestPath requestPath = mock(RequestPath.class);

        when(exchange.getRequest()).thenReturn(request);
        when(request.getPath()).thenReturn(requestPath);
        when(requestPath.value()).thenReturn("/api/test");
        when(request.getMethod()).thenReturn(HttpMethod.GET);
        when(request.getURI()).thenReturn(URI.create("/api/test"));
    }

    @Test
    void handleDomainValidation_shouldReturnBadRequest() {
        String errorMsg = "Test validation error";
        Mono<ResponseEntity<ApiError>> mono = handler.handleDomainValidation(
                new DomainValidationException(errorMsg), exchange);

        ResponseEntity<ApiError> response = mono.block();
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertApiError(response.getBody(), HttpStatus.BAD_REQUEST, errorMsg, "/api/test");
    }

    @Test
    void handleWebInput_shouldReturnBadRequest_ServerWebInputException() {
        ServerWebInputException ex = new ServerWebInputException("invalid param",
                null);
        Mono<ResponseEntity<ApiError>> mono = handler.handleWebInput(ex, exchange);
        ResponseEntity<ApiError> response = mono.block();

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("invalid param", response.getBody().getMessage());
        assertApiError(response.getBody(), HttpStatus.BAD_REQUEST, "invalid param", "/api/test");
    }

    @Test
    void handleWebInput_shouldReturnBadRequest_UnsupportedMediaType() {
        UnsupportedMediaTypeStatusException ex = new UnsupportedMediaTypeStatusException("application/xml");
        Mono<ResponseEntity<ApiError>> mono = handler.handleWebInput(ex, exchange);
        ResponseEntity<ApiError> response = mono.block();

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        assertNotNull(response.getBody());
        assertTrue(response.getBody().getMessage().startsWith("Unsupported content type"));
    }

    @Test
    void handleWebInput_shouldReturnBadRequest_DecodingException() {
        DecodingException ex = new DecodingException("bad json", new RuntimeException());
        Mono<ResponseEntity<ApiError>> mono = handler.handleWebInput(ex, exchange);
        ResponseEntity<ApiError> response = mono.block();

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().getMessage().contains("Malformed JSON"));
    }

    @Test
    void handleNotFound_shouldReturnNotFound() {
        String msg = "Resource not found";
        Mono<ResponseEntity<ApiError>> mono = handler.handleNotFound(
                new AccountNotFoundException(msg), exchange);
        ResponseEntity<ApiError> resp = mono.block();
        assertNotNull(resp);
        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
        assertApiError(resp.getBody(), HttpStatus.NOT_FOUND, msg, "/api/test");
    }

    @Test
    void handleConflict_shouldReturnConflict() {
        String accNumber = "ACC123";
        Mono<ResponseEntity<ApiError>> mono = handler.handleConflict(
                new DuplicatedAccountNumberException(accNumber), exchange);
        ResponseEntity<ApiError> resp = mono.block();
        assertNotNull(resp);
        assertEquals(HttpStatus.CONFLICT, resp.getStatusCode());
        assertApiError(resp.getBody(), HttpStatus.CONFLICT, "Account number already exists: "+accNumber, "/api/test");
    }

    @Test
    void handleDownstream_shouldReturnServiceUnavailable() {
        Mono<ResponseEntity<ApiError>> mono = handler.handleDownstream(
                new DownstreamServiceException("Backend offline", null), exchange);
        ResponseEntity<ApiError> resp = mono.block();
        assertNotNull(resp);
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, resp.getStatusCode());
        assertApiError(resp.getBody(), HttpStatus.SERVICE_UNAVAILABLE, "Backend offline", "/api/test");
    }

    @Test
    void handleUnexpected_shouldReturnInternalServerError() {
        Mono<ResponseEntity<ApiError>> mono = handler.handleUnexpected(
                new NullPointerException("null"), exchange);
        ResponseEntity<ApiError> resp = mono.block();
        assertNotNull(resp);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getStatusCode());
        assertApiError(resp.getBody(), HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error", "/api/test");
    }

    void assertApiError(ApiError error, HttpStatus status, String message, String path) {
        assertNotNull(error);
        assertEquals(status.value(), error.getStatus());
        assertEquals(status.getReasonPhrase(), error.getError());
        assertEquals(message, error.getMessage());
        assertEquals(path, error.getPath());
        assertNotNull(error.getTimestamp());
    }
}
