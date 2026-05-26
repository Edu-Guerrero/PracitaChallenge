package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.AccountsApi;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.CreateAccountRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.PagedAccountsResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateAccountRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper.AccountRestMapper;
import com.challenge.accounts_movements_service.application.input.port.AccountInputPort; // AJUSTA si tu puerto se llama distinto
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountsController implements AccountsApi {

    private final AccountInputPort accountService;     // o AccountUseCase / AccountInputPort
    private final AccountRestMapper accountApiMapper;

    @Override
    public Mono<ResponseEntity<PagedAccountsResponse>> listAccounts(UUID customerId, Integer page, Integer size, ServerWebExchange exchange) {
        log.info("HTTP GET /accounts customerId={} page={} size={}", customerId, page, size);

        return accountService.list(customerId, page, size) // -> Mono<Page<Account>> o similar
                .map(accountApiMapper::toPagedResponse)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<AccountResponse>> getAccountById(UUID accountId, ServerWebExchange exchange) {
        log.info("HTTP GET /accounts/{}", accountId);

        return accountService.getById(accountId)
                .map(accountApiMapper::toResponse)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<AccountResponse>> createAccount(CreateAccountRequest createAccountRequest, ServerWebExchange exchange) {
        log.info("HTTP POST /accounts customerId={} accountNumber={}",
                createAccountRequest.getCustomerId(), createAccountRequest.getAccountNumber());

        return accountService.create(accountApiMapper.toDomain(createAccountRequest), exchange)
                .map(saved -> ResponseEntity
                        .created(URI.create("/accounts/" + saved.getId()))
                        .body(accountApiMapper.toResponse(saved)));
    }

    @Override
    public Mono<ResponseEntity<AccountResponse>> updateAccount(UUID accountId, UpdateAccountRequest updateAccountRequest, ServerWebExchange exchange) {
        log.info("HTTP PUT /accounts/{} customerId={} accountNumber={}",
                accountId, updateAccountRequest.getCustomerId(), updateAccountRequest.getAccountNumber());

        return accountService.update(accountId, accountApiMapper.toDomain(accountId, updateAccountRequest))
                .map(accountApiMapper::toResponse)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteAccount(UUID accountId, ServerWebExchange exchange) {
        log.info("HTTP DELETE /accounts/{}", accountId);

        return accountService.delete(accountId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}
