package com.challenge.accounts_movements_service.application.input.port;

import com.challenge.accounts_movements_service.domain.model.AccountStatementReport;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

public interface ReportInputPort {
    Mono<AccountStatementReport> getAccountStatement(UUID clientId, LocalDate startDate, LocalDate endDate, ServerWebExchange exchange);
}