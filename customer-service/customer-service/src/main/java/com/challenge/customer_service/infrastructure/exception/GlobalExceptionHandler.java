package com.challenge.customer_service.infrastructure.exception;

import com.challenge.customer_service.domain.exception.CustomerNotFoundException;
import com.challenge.customer_service.domain.exception.DomainValidationException;
import com.challenge.customer_service.domain.exception.DuplicatedIdentificationException;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.ApiError;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.ApiErrorDetailsInner;
import java.time.OffsetDateTime;
import java.util.List;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.core.codec.DecodingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import static com.challenge.customer_service.infrastructure.utils.Constants.*;

@Slf4j
@Order(-2)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<ApiError>> handleBindException(WebExchangeBindException ex, ServerWebExchange exchange) {
        String path = exchange.getRequest().getPath().value();
        log.warn("Validation failed. path={} errors={}", path, ex.getErrorCount());

        List<ApiErrorDetailsInner> details = ex.getFieldErrors().stream()
                .map(this::toDetail)
                .toList();

        ApiError apiError = new ApiError();
        apiError.setTimestamp(OffsetDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        apiError.setMessage(MSG_VALIDATION_FAILED);
        apiError.setPath(path);
        apiError.setDetails(details);

        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError));
    }

    @ExceptionHandler(DomainValidationException.class)
    public Mono<ResponseEntity<ApiError>> handleBadRequest(DomainValidationException ex, ServerWebExchange exchange) {
        log.warn("Domain validation failed. path={} message={}",
                exchange.getRequest().getPath().value(),
                ex.getMessage());
        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage(), exchange);
    }

    @ExceptionHandler({DecodingException.class, IllegalArgumentException.class})
    public Mono<ResponseEntity<ApiError>> handleDecoding(Exception ex, ServerWebExchange exchange) {
        log.warn("Invalid request payload. path={} message={}",
                exchange.getRequest().getPath().value(),
                ex.getMessage());
        return buildError(HttpStatus.BAD_REQUEST, MSG_INVALID_REQUEST_PAYLOAD, exchange);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public Mono<ResponseEntity<ApiError>> handleNotFound(CustomerNotFoundException ex, ServerWebExchange exchange) {
        log.warn("Not found. path={} message={}",
                exchange.getRequest().getPath().value(),
                ex.getMessage());
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage(), exchange);
    }

    @ExceptionHandler(DuplicatedIdentificationException.class)
    public Mono<ResponseEntity<ApiError>> handleConflict(DuplicatedIdentificationException ex, ServerWebExchange exchange) {
        log.warn("Conflict. path={} message={}",
                exchange.getRequest().getPath().value(),
                ex.getMessage());
        return buildError(HttpStatus.CONFLICT, ex.getMessage(), exchange);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Mono<ResponseEntity<ApiError>> handleDataIntegrity(DataIntegrityViolationException ex, ServerWebExchange exchange) {
        ex.getMostSpecificCause();
        log.warn("Data integrity violation. path={} message={}",
                exchange.getRequest().getPath().value(),
                ex.getMostSpecificCause().getMessage());
        return buildError(HttpStatus.CONFLICT, MSG_CONFLICT_CURRENT_STATE, exchange);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<ApiError>> handleConstraintViolation(ConstraintViolationException ex,
                                                                    ServerWebExchange exchange) {
        String path = exchange.getRequest().getPath().value();
        log.warn("Constraint violation. path={} violations={}", path, ex.getConstraintViolations().size());

        List<ApiErrorDetailsInner> details = ex.getConstraintViolations().stream()
                .map(this::toDetail)
                .toList();

        ApiError apiError = new ApiError();
        apiError.setTimestamp(OffsetDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        apiError.setMessage(MSG_VALIDATION_FAILED);
        apiError.setPath(path);
        apiError.setDetails(details);

        return Mono.just(ResponseEntity.badRequest().body(apiError));
    }

    @ExceptionHandler(ServerWebInputException.class)
    public Mono<ResponseEntity<ApiError>> handleServerWebInput(ServerWebInputException ex, ServerWebExchange exchange) {
        String path = exchange.getRequest().getPath().value();

        log.warn("Bad request (input). path={} message={}", path, ex.getReason());

        return buildError(HttpStatus.BAD_REQUEST, MSG_INVALID_REQUEST_PAYLOAD, exchange);
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ApiError>> handleGeneric(Exception ex, ServerWebExchange exchange) {
        log.error("Unhandled error. path={} method={} message={}",
                exchange.getRequest().getPath().value(),
                exchange.getRequest().getMethod(),
                ex.getMessage(),
                ex);
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR, MSG_UNEXPECTED_ERROR, exchange);
    }

    private ApiErrorDetailsInner toDetail(FieldError fe) {
        ApiErrorDetailsInner d = new ApiErrorDetailsInner();
        d.setField(fe.getField());
        d.setIssue(fe.getDefaultMessage());
        return d;
    }

    private Mono<ResponseEntity<ApiError>> buildError(HttpStatus status, String message, ServerWebExchange exchange) {
        String path = exchange.getRequest().getPath().value();

        ApiError apiError = new ApiError();
        apiError.setTimestamp(OffsetDateTime.now());
        apiError.setStatus(status.value());
        apiError.setError(status.getReasonPhrase());
        apiError.setMessage(message);
        apiError.setPath(path);
        apiError.setDetails(List.of());

        return Mono.just(ResponseEntity.status(status).body(apiError));
    }

    private ApiErrorDetailsInner toDetail(ConstraintViolation<?> v) {
        ApiErrorDetailsInner d = new ApiErrorDetailsInner();
        d.setField(v.getPropertyPath() != null ? v.getPropertyPath().toString() : "unknown");
        d.setIssue(v.getMessage());
        return d;
    }
}