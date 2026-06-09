package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.application.input.port.AccountInputPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper.AccountRestMapper;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.CreateAccountRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.PagedAccountsResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateAccountRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountsControllerTest {

    private AccountInputPort accountService;
    private AccountRestMapper mapper;
    private AccountsController controller;
    private ServerWebExchange exchange;

    @BeforeEach
    void setUp() {
        accountService = mock(AccountInputPort.class);
        mapper = mock(AccountRestMapper.class);
        controller = new AccountsController(accountService, mapper);
        exchange = mock(ServerWebExchange.class);
    }

    @Test
    void listAccounts_shouldCallServiceAndMapper() {
        UUID customerId = UUID.randomUUID();
        int page = 1, size = 5;
        var pagedResponse = mock(PagedAccountsResponse.class);
        PagedResult<Account> pagedResult = mock(PagedResult.class);

        when(accountService.list(customerId, page, size)).thenReturn(Mono.just(pagedResult));
        when(mapper.toPagedResponse(any())).thenReturn(pagedResponse);

        var result = controller.listAccounts(customerId, page, size, exchange).block();
        assertNotNull(result);
        assertSame(pagedResponse, result.getBody());
        verify(accountService).list(customerId, page, size);
        verify(mapper).toPagedResponse(any());
    }

    @Test
    void getAccountById_shouldMapToResponse() {
        UUID accountId = UUID.randomUUID();
        var domainAcc = mock(com.challenge.accounts_movements_service.domain.model.Account.class);
        var apiResp = mock(AccountResponse.class);

        when(accountService.getById(accountId)).thenReturn(Mono.just(domainAcc));
        when(mapper.toResponse(domainAcc)).thenReturn(apiResp);

        var result = controller.getAccountById(accountId, exchange).block();
        assertNotNull(result);
        assertSame(apiResp, result.getBody());
        verify(accountService).getById(accountId);
        verify(mapper).toResponse(domainAcc);
    }

    @Test
    void createAccount_shouldCallMappingAndReturnCreated() {
        CreateAccountRequest req = mock(CreateAccountRequest.class);
        var domainAcc = mock(com.challenge.accounts_movements_service.domain.model.Account.class);
        var apiResp = mock(AccountResponse.class);
        UUID accId = UUID.randomUUID();
        when(domainAcc.getId()).thenReturn(accId);

        when(mapper.toDomain(req)).thenReturn(domainAcc);
        when(accountService.create(domainAcc, exchange)).thenReturn(Mono.just(domainAcc));
        when(mapper.toResponse(domainAcc)).thenReturn(apiResp);

        var result = controller.createAccount(req, exchange).block();
        assertNotNull(result);
        assertEquals("/accounts/" + accId, Objects.requireNonNull(result.getHeaders().getLocation()).toString());
        assertSame(apiResp, result.getBody());
    }

    @Test
    void updateAccount_shouldMapAndReturnOk() {
        UUID accId = UUID.randomUUID();
        UpdateAccountRequest req = mock(UpdateAccountRequest.class);
        var domainAcc = mock(com.challenge.accounts_movements_service.domain.model.Account.class);
        var apiResp = mock(AccountResponse.class);

        when(mapper.toDomain(accId, req)).thenReturn(domainAcc);
        when(accountService.update(accId, domainAcc)).thenReturn(Mono.just(domainAcc));
        when(mapper.toResponse(domainAcc)).thenReturn(apiResp);

        var result = controller.updateAccount(accId, req, exchange).block();
        assertNotNull(result);
        assertSame(apiResp, result.getBody());
        verify(accountService).update(accId, domainAcc);
        verify(mapper).toResponse(domainAcc);
    }

    @Test
    void deleteAccount_shouldReturnNoContent() {
        UUID accId = UUID.randomUUID();
        when(accountService.delete(accId)).thenReturn(Mono.empty());

        var result = controller.deleteAccount(accId, exchange).block();
        assertNotNull(result);
        assertEquals(204, result.getStatusCode().value());
    }
}
