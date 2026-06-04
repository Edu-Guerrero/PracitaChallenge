package com.challenge.accounts_movements_service.application.service.impl;

import com.challenge.accounts_movements_service.application.output.port.AccountRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.CustomerRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.MovementRepositoryPort;
import com.challenge.accounts_movements_service.domain.exception.DomainValidationException;
import com.challenge.accounts_movements_service.domain.model.AccountStatementReport;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean.Customer;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportServiceImplTest {

    private AccountRepositoryPort accountRepositoryPort;
    private MovementRepositoryPort movementRepositoryPort;
    private CustomerRepositoryPort customerRepositoryPort;
    private ReportServiceImpl reportService;

    @BeforeEach
    void setup() {
        accountRepositoryPort = mock(AccountRepositoryPort.class);
        movementRepositoryPort = mock(MovementRepositoryPort.class);
        customerRepositoryPort = mock(CustomerRepositoryPort.class);
        reportService = new ReportServiceImpl(accountRepositoryPort, movementRepositoryPort, customerRepositoryPort);
    }

    @Test
    void getAccountStatement_shouldThrowWhenClientIdIsNull() {
        Mono<AccountStatementReport> result = reportService.getAccountStatement(null, LocalDate.now(), LocalDate.now(), mock(ServerWebExchange.class));
        assertThrows(DomainValidationException.class, result::block);
    }

    @Test
    void getAccountStatement_shouldThrowWhenStartDateIsNull() {
        Mono<AccountStatementReport> result = reportService.getAccountStatement(UUID.randomUUID(), null, LocalDate.now(), mock(ServerWebExchange.class));
        assertThrows(DomainValidationException.class, result::block);
    }

    @Test
    void getAccountStatement_shouldThrowWhenEndDateIsNull() {
        Mono<AccountStatementReport> result = reportService.getAccountStatement(UUID.randomUUID(), LocalDate.now(), null, mock(ServerWebExchange.class));
        assertThrows(DomainValidationException.class, result::block);
    }

    @Test
    void getAccountStatement_shouldThrowWhenEndDateIsBeforeStartDate() {
        LocalDate now = LocalDate.now();
        Mono<AccountStatementReport> result = reportService.getAccountStatement(UUID.randomUUID(), now.plusDays(2), now, mock(ServerWebExchange.class));
        assertThrows(DomainValidationException.class, result::block);
    }

    @Test
    void getAccountStatement_shouldFetchWhenValid() {
        UUID clientId = UUID.randomUUID();
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(1);
        ServerWebExchange exchange = mock(ServerWebExchange.class);
        CustomerResponse mockResponse = new CustomerResponse();
        mockResponse.setId(clientId);

        when(customerRepositoryPort.getCustomerById(any(), any()))
                .thenReturn(Mono.just(mockResponse));

        when(accountRepositoryPort.findAll(any(), anyInt(), anyInt()))
                .thenReturn(Mono.just(new com.challenge.accounts_movements_service.application.util.PagedResult<>(java.util.List.of(), 0, 1, 0)));

        Mono<AccountStatementReport> result = reportService.getAccountStatement(clientId, start, end, exchange);
        assertDoesNotThrow(() -> result.block());
    }

    @Test
    void getAccountStatement_shouldMapAccountSectionsAndMovements() {

        UUID clientId = UUID.randomUUID();
        LocalDate start = LocalDate.of(2024,1,1);
        LocalDate end = LocalDate.of(2024,1,31);
        ServerWebExchange exchange = mock(ServerWebExchange.class);

        var cust = new com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean.CustomerResponse();
        cust.setId(clientId);
        when(customerRepositoryPort.getCustomerById(any(), any())).thenReturn(Mono.just(cust));

        var accId = UUID.randomUUID();
        var acc = com.challenge.accounts_movements_service.domain.model.Account.builder()
                .id(accId)
                .accountNumber("ACC01")
                .type(com.challenge.accounts_movements_service.domain.model.AccountType.CHECKING)
                .initialBalance(BigDecimal.valueOf(1000))
                .currentBalance(BigDecimal.valueOf(1500))
                .build();
        var paged = new com.challenge.accounts_movements_service.application.util.PagedResult<>(java.util.List.of(acc), 0, 1, 1);
        when(accountRepositoryPort.findAll(eq(clientId), anyInt(), anyInt()))
                .thenReturn(Mono.just(paged));

        var mov = com.challenge.accounts_movements_service.domain.model.Movement.builder()
                .id(UUID.randomUUID())
                .accountId(accId)
                .date(LocalDate.of(2024,1,15))
                .type(com.challenge.accounts_movements_service.domain.model.MovementType.CREDIT)
                .value(BigDecimal.valueOf(500))
                .balanceAfter(BigDecimal.valueOf(1500))
                .build();
        when(movementRepositoryPort.findByAccountIdAndDateRange(eq(accId), eq(start), eq(end)))
                .thenReturn(reactor.core.publisher.Flux.just(mov));

        var resultMono = reportService.getAccountStatement(clientId, start, end, exchange);

        var report = resultMono.block();
        assertNotNull(report);
        assertEquals(clientId, report.getClientId());
        assertEquals(start, report.getStartDate());
        assertEquals(end, report.getEndDate());
        assertEquals(1, report.getAccounts().size());
        var reportAccount = report.getAccounts().get(0);
        assertEquals(accId, reportAccount.getAccountId());
        assertEquals("ACC01", reportAccount.getAccountNumber());
        assertEquals(com.challenge.accounts_movements_service.domain.model.AccountType.CHECKING, reportAccount.getType());
        assertEquals(BigDecimal.valueOf(1000), reportAccount.getInitialBalance());
        assertEquals(BigDecimal.valueOf(1500), reportAccount.getCurrentBalance());
        assertEquals(1, reportAccount.getMovements().size());
        var reportMovement = reportAccount.getMovements().get(0);
        assertEquals(mov.getId(), reportMovement.getMovementId());
        assertEquals(mov.getDate(), reportMovement.getDate());
        assertEquals(mov.getType(), reportMovement.getType());
        assertEquals(mov.getValue(), reportMovement.getValue());
        assertEquals(mov.getBalanceAfter(), reportMovement.getBalanceAfter());
    }

}
