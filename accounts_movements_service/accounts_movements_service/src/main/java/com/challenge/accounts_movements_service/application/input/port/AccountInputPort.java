package com.challenge.accounts_movements_service.application.input.port;

import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Account;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountInputPort {
    Mono<Account> create(Account account, ServerWebExchange exchange);
    Mono<Account> update(UUID accountId, Account account);
    Mono<Void> delete(UUID accountId);
    Mono<Account> getById(UUID accountId);
    Mono<PagedResult<Account>> list(UUID customerId, int page, int size);

}
