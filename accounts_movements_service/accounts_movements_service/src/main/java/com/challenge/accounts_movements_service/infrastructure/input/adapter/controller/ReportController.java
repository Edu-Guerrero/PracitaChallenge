package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.application.input.port.ReportInputPort;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper.ReportRestMapper;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.ReportsApi;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountStatementReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReportController implements ReportsApi {

    private final ReportInputPort reportInputPort;
    private final ReportRestMapper reportRestMapper;

    @Override
    public Mono<ResponseEntity<AccountStatementReport>> getAccountStatementReport(
            UUID clientId, LocalDate startDate, LocalDate endDate, ServerWebExchange exchange) {

        log.info("HTTP GET /reports/{} startDate={} endDate={}", clientId, startDate, endDate);

        return reportInputPort.getAccountStatement(clientId, startDate, endDate, exchange)
                .map(reportRestMapper::toResponse)
                .map(ResponseEntity::ok);
    }
}
