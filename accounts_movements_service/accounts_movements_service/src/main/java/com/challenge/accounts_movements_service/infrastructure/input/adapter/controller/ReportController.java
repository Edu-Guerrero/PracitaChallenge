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

import static com.challenge.accounts_movements_service.infrastructure.util.Constants.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReportController implements ReportsApi {

    private final ReportInputPort reportInputPort;
    private final ReportRestMapper reportRestMapper;

    @Override
    public Mono<ResponseEntity<AccountStatementReport>> getAccountStatementReport(
            UUID clientId, LocalDate startDate, LocalDate endDate, ServerWebExchange exchange) {

        log.info(IN + ACTION_REPORT + "generating report for clientId={} startDate={} endDate={}", clientId, startDate, endDate);

        return reportInputPort.getAccountStatement(clientId, startDate, endDate, exchange)
                .map(reportRestMapper::toResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_REPORT + "report generated successfully for clientId={} startDate={} endDate={}",
                        clientId, startDate, endDate))
                .doOnError(e -> log.error(OUT + ACTION_REPORT + "error generation report for clientId={} startDate={} endDate={} Error: {}",
                        clientId, startDate, endDate, e.getMessage(), e));
    }
}
