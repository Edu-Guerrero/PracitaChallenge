package com.challenge.customer_service.infrastructure.exception;

import com.challenge.customer_service.domain.exception.CustomerNotFoundException;
import com.challenge.customer_service.domain.exception.DomainValidationException;
import com.challenge.customer_service.domain.exception.DuplicatedIdentificationException;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.ApiError;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.ApiErrorDetailsInner;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.core.codec.DecodingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleBadRequestShouldReturn400WithMessageAndEmptyDetails() {
        ServerWebExchange exchange = exchangeForPath("/customers");
        DomainValidationException ex = new DomainValidationException("invalid");

        Mono<ResponseEntity<ApiError>> mono = handler.handleBadRequest(ex, exchange);

        StepVerifier.create(mono)
                .assertNext(resp -> {
                    assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());

                    ApiError body = resp.getBody();
                    assertNotNull(body);

                    assertAll(
                            () -> assertEquals(400, body.getStatus()),
                            () -> assertEquals("Bad Request", body.getError()),
                            () -> assertEquals("invalid", body.getMessage()),
                            () -> assertEquals("/customers", body.getPath()),
                            () -> assertNotNull(body.getTimestamp()),
                            () -> assertNotNull(body.getDetails()),
                            () -> assertTrue(body.getDetails().isEmpty())
                    );
                })
                .verifyComplete();
    }

    @Test
    void handleNotFoundShouldReturn404WithMessage() {
        ServerWebExchange exchange = exchangeForPath("/customers/1");
        CustomerNotFoundException ex = new CustomerNotFoundException("Customer not found: 1");

        StepVerifier.create(handler.handleNotFound(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
                    assertNotNull(resp.getBody());
                    assertEquals(404, resp.getBody().getStatus());
                    assertEquals("Not Found", resp.getBody().getError());
                    assertEquals("Customer not found: 1", resp.getBody().getMessage());
                    assertEquals("/customers/1", resp.getBody().getPath());
                })
                .verifyComplete();
    }

    @Test
    void handleConflictShouldReturn409WithMessage() {
        ServerWebExchange exchange = exchangeForPath("/customers");
        DuplicatedIdentificationException ex = new DuplicatedIdentificationException("ABC");

        StepVerifier.create(handler.handleConflict(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.CONFLICT, resp.getStatusCode());
                    ApiError body = resp.getBody();
                    assertNotNull(body);
                    assertEquals(409, body.getStatus());
                    assertEquals("Conflict", body.getError());
                    assertTrue(body.getMessage().contains("ABC"));
                    assertEquals("/customers", body.getPath());
                })
                .verifyComplete();
    }

    @Test
    void handleDecodingShouldReturn400WithGenericInvalidPayloadMessage() {
        ServerWebExchange exchange = exchangeForPath("/customers");
        DecodingException ex = new DecodingException("bad json");

        StepVerifier.create(handler.handleDecoding(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
                    ApiError body = resp.getBody();
                    assertNotNull(body);
                    assertEquals(400, body.getStatus());
                    assertEquals("Bad Request", body.getError());
                    assertEquals("Invalid request payload", body.getMessage());
                    assertEquals("/customers", body.getPath());
                })
                .verifyComplete();
    }

    @Test
    void handleDecodingShouldAlsoHandleIllegalArgumentException() {
        ServerWebExchange exchange = exchangeForPath("/customers");
        IllegalArgumentException ex = new IllegalArgumentException("invalid enum");

        StepVerifier.create(handler.handleDecoding(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
                    assertNotNull(resp.getBody());
                    assertEquals("Invalid request payload", resp.getBody().getMessage());
                })
                .verifyComplete();
    }

    @Test
    void handleDataIntegrityShouldReturn409WithGenericMessage() {
        ServerWebExchange exchange = exchangeForPath("/customers");
        DataIntegrityViolationException ex =
                new DataIntegrityViolationException("constraint", new RuntimeException("duplicate key"));

        StepVerifier.create(handler.handleDataIntegrity(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.CONFLICT, resp.getStatusCode());
                    ApiError body = resp.getBody();
                    assertNotNull(body);
                    assertEquals(409, body.getStatus());
                    assertEquals("Conflict", body.getError());
                    assertEquals("Conflict with current state", body.getMessage());
                    assertEquals("/customers", body.getPath());
                })
                .verifyComplete();
    }

    @Test
    void handleGenericShouldReturn500WithUnexpectedErrorMessage() {
        ServerWebExchange exchange = exchangeForPath("/customers");
        Exception ex = new RuntimeException("boom");

        StepVerifier.create(handler.handleGeneric(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getStatusCode());
                    ApiError body = resp.getBody();
                    assertNotNull(body);
                    assertEquals(500, body.getStatus());
                    assertEquals("Internal Server Error", body.getError());
                    assertEquals("Unexpected error", body.getMessage());
                    assertEquals("/customers", body.getPath());
                })
                .verifyComplete();
    }

    @Test
    void handleConstraintViolationShouldReturn400WithDetailsFromViolations() {
        ServerWebExchange exchange = exchangeForPath("/customers");

        ConstraintViolation<?> v1 = constraintViolation("person.name", "must not be blank");
        ConstraintViolation<?> v2 = constraintViolation("person.phone", "must not be blank");

        ConstraintViolationException ex = new ConstraintViolationException(Set.of(v1, v2));

        StepVerifier.create(handler.handleConstraintViolation(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
                    ApiError body = resp.getBody();
                    assertNotNull(body);

                    assertEquals(400, body.getStatus());
                    assertEquals("Bad Request", body.getError());
                    assertEquals("Validation failed", body.getMessage());
                    assertEquals("/customers", body.getPath());

                    assertNotNull(body.getDetails());
                    assertEquals(2, body.getDetails().size());


                    List<String> fields = body.getDetails().stream().map(ApiErrorDetailsInner::getField).toList();
                    assertTrue(fields.contains("person.name"));
                    assertTrue(fields.contains("person.phone"));
                })
                .verifyComplete();
    }

    @Test
    void handleBindExceptionShouldReturn400AndMapFieldErrorsToDetails() {
        ServerWebExchange exchange = exchangeForPath("/customers");

        WebExchangeBindException ex = mock(WebExchangeBindException.class);
        when(ex.getErrorCount()).thenReturn(2);

        var fe1 = new org.springframework.validation.FieldError("req", "name", "must not be blank");
        var fe2 = new org.springframework.validation.FieldError("req", "gender", "must not be null");

        when(ex.getFieldErrors()).thenReturn(List.of(fe1, fe2));

        StepVerifier.create(handler.handleBindException(ex, exchange))
                .assertNext(resp -> {
                    assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
                    ApiError body = resp.getBody();
                    assertNotNull(body);

                    assertAll(
                            () -> assertEquals(400, body.getStatus()),
                            () -> assertEquals("Bad Request", body.getError()),
                            () -> assertEquals("Validation failed", body.getMessage()),
                            () -> assertEquals("/customers", body.getPath()),
                            () -> assertNotNull(body.getTimestamp()),
                            () -> assertNotNull(body.getDetails()),
                            () -> assertEquals(2, body.getDetails().size())
                    );

                    assertEquals("name", body.getDetails().get(0).getField());
                    assertEquals("must not be blank", body.getDetails().get(0).getIssue());

                    assertEquals("gender", body.getDetails().get(1).getField());
                    assertEquals("must not be null", body.getDetails().get(1).getIssue());
                })
                .verifyComplete();
    }


    private ServerWebExchange exchangeForPath(String path) {
        ServerWebExchange exchange = mock(ServerWebExchange.class);
        ServerHttpRequest request = mock(ServerHttpRequest.class);
        RequestPath requestPath = mock(RequestPath.class);

        when(exchange.getRequest()).thenReturn(request);
        when(request.getPath()).thenReturn(requestPath);
        when(requestPath.value()).thenReturn(path);

        when(request.getMethod()).thenReturn(HttpMethod.GET);

        return exchange;
    }

    private ConstraintViolation<?> constraintViolation(String propertyPath, String message) {
        ConstraintViolation<?> v = mock(ConstraintViolation.class);
        when(v.getMessage()).thenReturn(message);

        jakarta.validation.Path path = mock(jakarta.validation.Path.class);
        when(path.toString()).thenReturn(propertyPath);

        when(v.getPropertyPath()).thenReturn(path);
        return v;
    }
}
