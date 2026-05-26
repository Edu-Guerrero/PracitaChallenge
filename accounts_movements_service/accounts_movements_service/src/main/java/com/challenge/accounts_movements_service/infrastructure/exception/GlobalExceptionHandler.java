package com.challenge.accounts_movements_service.infrastructure.exception;

import com.challenge.accounts_movements_service.domain.exception.*;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.ApiError;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.ApiErrorDetailsInner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ---------- 400 BAD REQUEST ----------
    @ExceptionHandler(DomainValidationException.class)
    public Mono<ResponseEntity<ApiError>> handleDomainValidation(DomainValidationException ex, ServerWebExchange exchange) {
        return Mono.just(build(exchange, HttpStatus.BAD_REQUEST, ex.getMessage(), null, ex));
    }

    /**
     * Covers typical WebFlux input problems:
     * - Missing required query param (startDate/endDate in /reports)
     * - Invalid UUID/date format
     * - Invalid JSON body
     */
    @ExceptionHandler({
            ServerWebInputException.class,
            DecodingException.class,
            UnsupportedMediaTypeStatusException.class
    })
    public Mono<ResponseEntity<ApiError>> handleWebInput(Exception ex, ServerWebExchange exchange) {
        String message = "Invalid request";
        List<ApiErrorDetailsInner> details = null;

        if (ex instanceof ServerWebInputException swe) {
            message = swe.getReason() != null ? swe.getReason() : message;

            String paramName = null;
            var methodParameter = swe.getMethodParameter();
            if (methodParameter != null) {
                paramName = methodParameter.getParameterName();
            }
            if (paramName != null && !paramName.isBlank()) {
                ApiErrorDetailsInner d = new ApiErrorDetailsInner();
                d.setField(paramName);
                d.setIssue(message);
                details = List.of(d);
            }
        } else if (ex instanceof UnsupportedMediaTypeStatusException umt) {
            message = "Unsupported content type: " + umt.getContentType();
        } else if (ex instanceof DecodingException) {
            message = "Malformed JSON request body: " + ex.getMessage();
        }

        // Temporal: log entero para debug
        log.info("Validation failure details: {}", ex.getMessage(), ex);

        return Mono.just(build(exchange, HttpStatus.BAD_REQUEST, message, details, ex));
    }

    // ---------- 404 NOT FOUND ----------
    @ExceptionHandler({
            AccountNotFoundException.class,
            MovementNotFoundException.class,
            CustomerNotFoundException.class
    })
    public Mono<ResponseEntity<ApiError>> handleNotFound(DomainException ex, ServerWebExchange exchange) {
        return Mono.just(build(exchange, HttpStatus.NOT_FOUND, ex.getMessage(), null, ex));
    }

    // ---------- 409 CONFLICT ----------
    @ExceptionHandler({
            DuplicatedAccountNumberException.class,
            InsufficientFundsException.class,
            AccountInactiveException.class
    })
    public Mono<ResponseEntity<ApiError>> handleConflict(DomainException ex, ServerWebExchange exchange) {
        // For F3: InsufficientFundsException message should be exactly "Saldo no disponible"
        return Mono.just(build(exchange, HttpStatus.CONFLICT, ex.getMessage(), null, ex));
    }

    // ---------- 503 SERVICE UNAVAILABLE ----------
    @ExceptionHandler(DownstreamServiceException.class)
    public Mono<ResponseEntity<ApiError>> handleDownstream(DownstreamServiceException ex, ServerWebExchange exchange) {
        return Mono.just(build(exchange, HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), null, ex));
    }

    // ---------- 500 INTERNAL SERVER ERROR (fallback) ----------
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ApiError>> handleUnexpected(Exception ex, ServerWebExchange exchange) {
        // Log stacktrace for diagnostics, but do not expose it to clients
        log.error("Unhandled error at {} {}", exchange.getRequest().getMethod(), exchange.getRequest().getURI(), ex);

        return Mono.just(build(exchange, HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error", null, ex));
    }

    // ---------- builder ----------
    private ResponseEntity<ApiError> build(ServerWebExchange exchange,
                                           HttpStatus status,
                                           String message,
                                           List<ApiErrorDetailsInner> details,
                                           Exception exForLog) {

        ApiError apiError = new ApiError();
        apiError.setTimestamp(OffsetDateTime.now());
        apiError.setStatus(status.value());
        apiError.setError(status.getReasonPhrase());
        apiError.setMessage(message);
        apiError.setPath(exchange.getRequest().getPath().value());

        if (details != null && !details.isEmpty()) {
            apiError.setDetails(details);
        }

        // Log with a level depending on status
        exchange.getRequest().getMethod();
        String method = exchange.getRequest().getMethod().name();
        String path = exchange.getRequest().getPath().value();

        if (status.is5xxServerError()) {
            log.error("HTTP {} {} -> {} {} | message={}", method, path, status.value(), status.getReasonPhrase(), message, exForLog);
        } else if (status == HttpStatus.CONFLICT) {
            log.warn("HTTP {} {} -> {} {} | message={}", method, path, status.value(), status.getReasonPhrase(), message);
        } else if (status == HttpStatus.NOT_FOUND) {
            log.warn("HTTP {} {} -> {} {} | message={}", method, path, status.value(), status.getReasonPhrase(), message);
        } else {
            log.info("HTTP {} {} -> {} {} | message={}", method, path, status.value(), status.getReasonPhrase(), message);
        }

        return ResponseEntity.status(status).body(apiError);
    }
}
