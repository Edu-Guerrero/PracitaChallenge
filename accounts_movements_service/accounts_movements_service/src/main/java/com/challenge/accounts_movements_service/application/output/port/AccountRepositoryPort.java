package com.challenge.accounts_movements_service.application.output.port;

import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Account;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface AccountRepositoryPort {
    Mono<Account> save(Account account);
    Mono<Account> findById(UUID accountId);
    Mono<Void> deleteById(UUID accountId);

    Mono<Boolean> existsByAccountNumber(String accountNumber);

    Mono<PagedResult<Account>> findAll(UUID customerId, int page, int size);
}