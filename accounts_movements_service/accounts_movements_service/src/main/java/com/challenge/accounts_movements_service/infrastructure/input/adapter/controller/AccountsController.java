package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.AccountsApi;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.CreateAccountRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.PagedAccountsResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateAccountRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper.AccountRestMapper;
import com.challenge.accounts_movements_service.application.input.port.AccountInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

import static com.challenge.accounts_movements_service.infrastructure.util.Constants.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountsController implements AccountsApi {

    private final AccountInputPort accountService;
    private final AccountRestMapper accountApiMapper;

    @Override
    public Mono<ResponseEntity<PagedAccountsResponse>> listAccounts(UUID customerId, Integer page, Integer size, ServerWebExchange exchange) {
        log.info(IN + ACTION_LIST + "list accounts customerId={} page={} size={}", customerId, page, size);

        return accountService.list(customerId, page, size)
                .map(accountApiMapper::toPagedResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_LIST + "accounts listed successfully customerId={} page={} size={}",
                        customerId, page, size))
                .doOnError(e -> log.error(OUT + ACTION_LIST + "error listing accounts customerId={} page={} size={}. Error: {}",
                        customerId, page, size, e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<AccountResponse>> getAccountById(UUID accountId, ServerWebExchange exchange) {
        log.info(IN  + ACTION_GET_BY_ID + "get accounts with id: {}", accountId);

        return accountService.getById(accountId)
                .map(accountApiMapper::toResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_GET_BY_ID + "account  retrieved successfully id={}",
                        resp != null && resp.getBody() != null ? resp.getBody().getId() : null))
                .doOnError(e -> log.error(OUT + ACTION_GET_BY_ID + "error retrieving account id={}. Error: {}",accountId, e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<AccountResponse>> createAccount(CreateAccountRequest createAccountRequest, ServerWebExchange exchange) {
        log.info(IN + ACTION_CREATE + "create account customerId={} accountNumber={}",
                createAccountRequest.getCustomerId(), createAccountRequest.getAccountNumber());

        return accountService.create(accountApiMapper.toDomain(createAccountRequest), exchange)
                .map(saved -> ResponseEntity
                        .created(URI.create("/accounts/" + saved.getId()))
                        .body(accountApiMapper.toResponse(saved)))
                .doOnSuccess(resp -> log.info(OUT + ACTION_CREATE + "account created successfully customerId={} accountNumber={}",
                        createAccountRequest.getCustomerId(), createAccountRequest.getAccountNumber()))
                .doOnError(e -> log.error(OUT + ACTION_CREATE + "error creating account. Error: {}", e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<AccountResponse>> updateAccount(UUID accountId, UpdateAccountRequest updateAccountRequest, ServerWebExchange exchange) {
        log.info(IN + ACTION_UPDATE + "update account: {} customerId={} accountNumber={}",
                accountId, updateAccountRequest.getCustomerId(), updateAccountRequest.getAccountNumber());

        return accountService.update(accountId, accountApiMapper.toDomain(accountId, updateAccountRequest))
                .map(accountApiMapper::toResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_UPDATE + "account updated successfully {} customerId={} accountNumber={}",
                        accountId, updateAccountRequest.getCustomerId(), updateAccountRequest.getAccountNumber()))
                .doOnError(e -> log.error(OUT + ACTION_UPDATE + "error updating account. Error: {}",
                        e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteAccount(UUID accountId, ServerWebExchange exchange) {
        log.info(IN + ACTION_DELETE + "delete account with id: {}", accountId);

        return accountService.delete(accountId)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .doOnSuccess(message -> log.info(OUT + ACTION_DELETE + "delete account successfully with id {}", accountId))
                .doOnError(e -> log.error(OUT + ACTION_DELETE + "Error deleting account. Error: {}", e.getMessage()));
    }
}
