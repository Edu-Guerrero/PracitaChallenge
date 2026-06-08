package com.challenge.accounts_movements_service.application.service.impl;

import com.challenge.accounts_movements_service.application.input.port.AccountInputPort;
import com.challenge.accounts_movements_service.application.output.port.AccountRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.CustomerRepositoryPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.exception.DomainValidationException;
import com.challenge.accounts_movements_service.domain.exception.DuplicatedAccountNumberException;
import com.challenge.accounts_movements_service.domain.exception.CustomerNotFoundException;
import com.challenge.accounts_movements_service.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

import static com.challenge.accounts_movements_service.application.util.Constants.*;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountInputPort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public Mono<Account> create(Account account, ServerWebExchange exchange) {
        return Mono.justOrEmpty(account)
                .switchIfEmpty(Mono.error(new DomainValidationException(ACCOUNT_REQUIRED)))
                .flatMap(this::validateForCreate)
                .flatMap(acc -> validateCustomerExists(acc, exchange))
                .flatMap(this::validateAccountNumberNotDuplicated)
                .map(this::ensureDefaultsForCreate)
                .flatMap(accountRepositoryPort::save);
    }

    @Override
    public Mono<Account> update(UUID accountId, Account account) {
        if (accountId == null) {
            return Mono.error(new DomainValidationException(ACCOUNT_ID_REQUIRED));
        }

        return accountRepositoryPort.findById(accountId)
                .switchIfEmpty(Mono.error(new com.challenge.accounts_movements_service.domain.exception.AccountNotFoundException(accountId)))
                .flatMap(existing -> Mono.justOrEmpty(account)
                        .switchIfEmpty(Mono.error(new DomainValidationException(ACCOUNT_REQUIRED)))
                        .flatMap(acc -> validateForUpdate(accountId, existing, acc))
                )
                .flatMap(accountRepositoryPort::save);
    }

    @Override
    public Mono<Void> delete(UUID accountId) {
        if (accountId == null) {
            return Mono.error(new DomainValidationException(ACCOUNT_ID_REQUIRED));
        }

        return accountRepositoryPort.findById(accountId)
                .switchIfEmpty(Mono.error(new com.challenge.accounts_movements_service.domain.exception.AccountNotFoundException(accountId)))
                .flatMap(a -> accountRepositoryPort.deleteById(accountId));
    }

    @Override
    public Mono<Account> getById(UUID accountId) {
        if (accountId == null) {
            return Mono.error(new DomainValidationException(ACCOUNT_ID_REQUIRED));
        }
        return accountRepositoryPort.findById(accountId)
                .switchIfEmpty(Mono.error(new com.challenge.accounts_movements_service.domain.exception.AccountNotFoundException(accountId)));
    }

    @Override
    public Mono<PagedResult<Account>> list(UUID customerId, int page, int size) {
        if (page < 0) {
            return Mono.error(new DomainValidationException(PAGE_MIN_ZERO));
        }
        if (size <= 0 || size > 100) {
            return Mono.error(new DomainValidationException(SIZE_RANGE));
        }
        return accountRepositoryPort.findAll(customerId, page, size);
    }

    private Mono<Account> validateForCreate(Account account) {
        if (account.getCustomerId() == null) return Mono.error(new DomainValidationException(CUSTOMER_ID_REQUIRED));
        if (account.getAccountNumber() == null || account.getAccountNumber().trim().isEmpty())
            return Mono.error(new DomainValidationException(ACCOUNT_NUMBER_REQUIRED));
        if (account.getType() == null) return Mono.error(new DomainValidationException(TYPE_REQUIRED));
        if (account.getInitialBalance() == null || account.getInitialBalance().compareTo(BigDecimal.ZERO) < 0)
            return Mono.error(new DomainValidationException(INITIAL_BALANCE_REQUIRED));
        if (account.getCurrentBalance() != null && account.getCurrentBalance().compareTo(BigDecimal.ZERO) < 0)
            return Mono.error(new DomainValidationException(CURRENT_BALANCE_REQUIRED));
        return Mono.just(account);
    }

    private Mono<Account> validateCustomerExists(Account account, ServerWebExchange exchange) {
        return customerRepositoryPort.getCustomerById(exchange, account.getCustomerId())
                .flatMap(exists -> exists.getId().equals(account.getCustomerId())
                        ? Mono.just(account)
                        : Mono.error(new CustomerNotFoundException(account.getCustomerId()))
                );
    }

    private Mono<Account> validateAccountNumberNotDuplicated(Account account) {
        return accountRepositoryPort.existsByAccountNumber(account.getAccountNumber())
                .flatMap(exists -> exists
                        ? Mono.error(new DuplicatedAccountNumberException(account.getAccountNumber()))
                        : Mono.just(account)
                );
    }

    private Account ensureDefaultsForCreate(Account account) {
        if (account.getId() == null) {
            account.setId(UUID.randomUUID());
        }
        if (account.getCurrentBalance() == null) {
            account.setCurrentBalance(account.getInitialBalance() != null ? account.getInitialBalance() : BigDecimal.ZERO);
        }
        return account;
    }

    private Mono<Account> validateForUpdate(UUID accountId, Account existing, Account incoming) {

        incoming.setId(accountId);

        if (incoming.getCustomerId() == null) {
            incoming.setCustomerId(existing.getCustomerId());
        }

        incoming.setCurrentBalance(existing.getCurrentBalance());

        if (incoming.getAccountNumber() == null || incoming.getAccountNumber().trim().isEmpty())
            return Mono.error(new DomainValidationException(ACCOUNT_NUMBER_REQUIRED));
        if (incoming.getType() == null) return Mono.error(new DomainValidationException(TYPE_REQUIRED));
        if (incoming.getInitialBalance() == null || incoming.getInitialBalance().compareTo(BigDecimal.ZERO) < 0)
            return Mono.error(new DomainValidationException(INITIAL_BALANCE_REQUIRED));

        boolean accountNumberChanged = !existing.getAccountNumber().equals(incoming.getAccountNumber());
        if (!accountNumberChanged) {
            return Mono.just(incoming);
        }

        return accountRepositoryPort.existsByAccountNumber(incoming.getAccountNumber())
                .flatMap(exists -> exists
                        ? Mono.error(new DuplicatedAccountNumberException(incoming.getAccountNumber()))
                        : Mono.just(incoming)
                );
    }
}
