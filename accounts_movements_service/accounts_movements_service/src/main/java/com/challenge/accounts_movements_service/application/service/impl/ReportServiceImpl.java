package com.challenge.accounts_movements_service.application.service.impl;

import com.challenge.accounts_movements_service.application.input.port.ReportInputPort;
import com.challenge.accounts_movements_service.application.output.port.AccountRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.CustomerRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.MovementRepositoryPort;
import com.challenge.accounts_movements_service.domain.exception.CustomerNotFoundException;
import com.challenge.accounts_movements_service.domain.exception.DomainValidationException;
import com.challenge.accounts_movements_service.domain.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportInputPort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final MovementRepositoryPort movementRepositoryPort;
    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public Mono<AccountStatementReport> getAccountStatement(UUID clientId, LocalDate startDate, LocalDate endDate, ServerWebExchange exchange) {
        if (clientId == null) {
            return Mono.error(new DomainValidationException("clientId is required"));
        }
        if (startDate == null) {
            return Mono.error(new DomainValidationException("startDate is required"));
        }
        if (endDate == null) {
            return Mono.error(new DomainValidationException("endDate is required"));
        }
        if (endDate.isBefore(startDate)) {
            return Mono.error(new DomainValidationException("endDate must be >= startDate"));
        }

        return customerRepositoryPort.getCustomerById(exchange, clientId)
                .flatMap(exists -> exists.getId().equals(clientId)
                        ? buildReport(clientId, startDate, endDate)
                        : Mono.error(new CustomerNotFoundException(clientId))
                );
    }

    private Mono<AccountStatementReport> buildReport(UUID clientId, LocalDate startDate, LocalDate endDate) {

        return accountRepositoryPort.findAll(clientId, 0, 1000)
                .flatMapMany(paged -> {
                    List<Account> accounts = paged.content();
                    return Flux.fromIterable(accounts);
                })
                .flatMap(account -> buildAccountSection(account, startDate, endDate))
                .collectList()
                .map(accountSections -> AccountStatementReport.builder()
                        .clientId(clientId)
                        .startDate(startDate)
                        .endDate(endDate)
                        .accounts(accountSections)
                        .build());
    }

    private Mono<AccountStatementReportAccount> buildAccountSection(Account account, LocalDate startDate, LocalDate endDate) {
        return movementRepositoryPort.findByAccountIdAndDateRange(account.getId(), startDate, endDate)
                .collectList()
                .map(movements -> toReportAccount(account, movements));
    }

    private AccountStatementReportAccount toReportAccount(Account account, List<Movement> movements) {
        List<AccountStatementReportMovement> reportMovements = movements.stream()
                .map(mv -> AccountStatementReportMovement.builder()
                        .movementId(mv.getId())
                        .date(mv.getDate())
                        .type(mv.getType())
                        .value(mv.getValue())
                        .balanceAfter(mv.getBalanceAfter())
                        .build())
                .toList();

        return AccountStatementReportAccount.builder()
                .accountId(account.getId())
                .accountNumber(account.getAccountNumber())
                .type(account.getType())
                .initialBalance(account.getInitialBalance())
                .currentBalance(account.getCurrentBalance())
                .movements(reportMovements)
                .build();
    }
}
