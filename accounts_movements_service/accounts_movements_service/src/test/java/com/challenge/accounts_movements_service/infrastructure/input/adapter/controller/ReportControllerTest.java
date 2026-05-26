package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.application.input.port.ReportInputPort;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper.ReportRestMapper;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountStatementReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportControllerTest {

    private ReportInputPort reportInputPort;
    private ReportRestMapper reportRestMapper;
    private ReportController controller;
    private ServerWebExchange exchange;

    @BeforeEach
    void setUp() {
        reportInputPort = mock(ReportInputPort.class);
        reportRestMapper = mock(ReportRestMapper.class);
        controller = new ReportController(reportInputPort, reportRestMapper);
        exchange = mock(ServerWebExchange.class);
    }

    @Test
    void getAccountStatementReport_shouldDelegateAndReturnOk() {
        UUID clientId = UUID.randomUUID();
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 31);
        var domainRep = mock(com.challenge.accounts_movements_service.domain.model.AccountStatementReport.class);
        var beanRep = mock(AccountStatementReport.class);

        when(reportInputPort.getAccountStatement(clientId, startDate, endDate, exchange)).thenReturn(Mono.just(domainRep));
        when(reportRestMapper.toResponse(domainRep)).thenReturn(beanRep);

        var result = controller.getAccountStatementReport(clientId, startDate, endDate, exchange).block();
        assertNotNull(result);
        assertSame(beanRep, result.getBody());
        verify(reportInputPort).getAccountStatement(clientId, startDate, endDate, exchange);
        verify(reportRestMapper).toResponse(domainRep);
    }
}
