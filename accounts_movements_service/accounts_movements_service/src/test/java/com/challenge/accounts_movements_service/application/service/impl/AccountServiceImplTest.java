package com.challenge.accounts_movements_service.application.service.impl;

import com.challenge.accounts_movements_service.application.output.port.AccountRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.CustomerRepositoryPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.exception.*;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.AccountType;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceImplTest {

    private AccountRepositoryPort accountRepositoryPort;
    private CustomerRepositoryPort customerRepositoryPort;
    private AccountServiceImpl accountService;
    private ServerWebExchange exchange;

    @BeforeEach
    void setup() {
        accountRepositoryPort = mock(AccountRepositoryPort.class);
        customerRepositoryPort = mock(CustomerRepositoryPort.class);
        accountService = new AccountServiceImpl(accountRepositoryPort, customerRepositoryPort);
        exchange = mock(ServerWebExchange.class);
    }


    @Test
    void create_shouldThrowWhenAccountIsNull() {
        Mono<Account> result = accountService.create(null, exchange);
        assertThrows(DomainValidationException.class, () -> result.block());
    }

    @Test
    void create_shouldFailWhenHasValidationErrors() {
        Account account = new Account();
        StepVerifier.create(accountService.create(account, exchange))
                .expectError(DomainValidationException.class)
                .verify();
    }

    @Test
    void create_shouldFailIfCustomerDoesNotExist() {
        Account account = new Account();
        UUID customerId = UUID.randomUUID();
        account.setCustomerId(customerId);
        account.setAccountNumber("333");
        account.setType(AccountType.SAVINGS);
        account.setInitialBalance(BigDecimal.ZERO);

        when(customerRepositoryPort.getCustomerById(exchange, customerId))
                .thenReturn(Mono.just(customerWithID(UUID.randomUUID())));

        StepVerifier.create(accountService.create(account, exchange))
                .expectError(CustomerNotFoundException.class)
                .verify();
    }

    @Test
    void create_shouldFailIfAccountNumberDuplicated() {
        Account account = validAccount();
        when(customerRepositoryPort.getCustomerById(any(), any())).thenReturn(Mono.just(customerWithID(account.getCustomerId())));
        when(accountRepositoryPort.existsByAccountNumber(account.getAccountNumber())).thenReturn(Mono.just(true));
        StepVerifier.create(accountService.create(account, exchange))
                .expectError(DuplicatedAccountNumberException.class)
                .verify();
    }

    @Test
    void create_shouldSucceedWithValidData() {
        Account account = validAccount();
        when(customerRepositoryPort.getCustomerById(any(), any())).thenReturn(Mono.just(customerWithID(account.getCustomerId())));
        when(accountRepositoryPort.existsByAccountNumber(account.getAccountNumber())).thenReturn(Mono.just(false));
        when(accountRepositoryPort.save(any())).thenReturn(Mono.just(account));

        StepVerifier.create(accountService.create(account, exchange))
                .expectNextMatches(a -> a.getAccountNumber().equals("A0001") && a.getCustomerId().equals(account.getCustomerId()))
                .verifyComplete();

        verify(accountRepositoryPort).save(any());
    }


    @Test
    void update_shouldThrowWhenAccountIdIsNull() {
        assertThrows(DomainValidationException.class, () -> accountService.update(null, validAccount()).block());
    }

    @Test
    void update_shouldThrowWhenAccountIsNull() {
        UUID id = UUID.randomUUID();
        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(validAccount()));
        assertThrows(DomainValidationException.class, () -> accountService.update(id, null).block());
    }

    @Test
    void update_shouldThrowWhenAccountNotFound() {
        UUID id = UUID.randomUUID();
        when(accountRepositoryPort.findById(id)).thenReturn(Mono.empty());
        assertThrows(AccountNotFoundException.class, () -> accountService.update(id, validAccount()).block());
    }

    @Test
    void update_shouldFailWhenAccountNumberIsEmptyOrNull() {
        UUID id = UUID.randomUUID();
        Account existing = validAccount();
        Account incoming = validAccount();
        incoming.setAccountNumber(null);

        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        assertThrows(DomainValidationException.class, () -> accountService.update(id, incoming).block());

        incoming.setAccountNumber(" ");
        assertThrows(DomainValidationException.class, () -> accountService.update(id, incoming).block());
    }

    @Test
    void update_shouldFailWhenTypeIsNull() {
        UUID id = UUID.randomUUID();
        Account existing = validAccount();
        Account incoming = validAccount();
        incoming.setType(null);

        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        assertThrows(DomainValidationException.class, () -> accountService.update(id, incoming).block());
    }

    @Test
    void update_shouldFailWhenInitialBalanceIsInvalid() {
        UUID id = UUID.randomUUID();
        Account existing = validAccount();
        Account incoming = validAccount();
        incoming.setInitialBalance(null);

        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        assertThrows(DomainValidationException.class, () -> accountService.update(id, incoming).block());

        incoming.setInitialBalance(BigDecimal.valueOf(-10));
        assertThrows(DomainValidationException.class, () -> accountService.update(id, incoming).block());
    }

    @Test
    void update_shouldFailIfAccountNumberChangedAndIsDuplicate() {
        UUID id = UUID.randomUUID();
        Account existing = validAccount();
        existing.setAccountNumber("A0001");
        Account incoming = validAccount();
        incoming.setAccountNumber("A0002");

        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(accountRepositoryPort.existsByAccountNumber("A0002")).thenReturn(Mono.just(true));
        assertThrows(DuplicatedAccountNumberException.class, () -> accountService.update(id, incoming).block());
    }

    @Test
    void update_shouldSucceedIfAccountNumberNotChanged() {
        UUID id = UUID.randomUUID();
        Account existing = validAccount();
        existing.setAccountNumber("A0001");
        Account incoming = validAccount();
        incoming.setAccountNumber("A0001");

        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(accountRepositoryPort.save(any())).thenReturn(Mono.just(incoming));
        StepVerifier.create(accountService.update(id, incoming))
                .expectNext(incoming)
                .verifyComplete();
    }

    @Test
    void update_shouldSucceedIfAccountNumberChangedAndNotDuplicate() {
        UUID id = UUID.randomUUID();
        Account existing = validAccount();
        existing.setAccountNumber("OLDNUM");
        Account incoming = validAccount();
        incoming.setAccountNumber("NEWNUM");

        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(accountRepositoryPort.existsByAccountNumber("NEWNUM")).thenReturn(Mono.just(false));
        when(accountRepositoryPort.save(any())).thenReturn(Mono.just(incoming));
        StepVerifier.create(accountService.update(id, incoming))
                .expectNext(incoming)
                .verifyComplete();
    }


    @Test
    void delete_shouldThrowWhenAccountIdIsNull() {
        assertThrows(DomainValidationException.class, () -> accountService.delete(null).block());
    }

    @Test
    void delete_shouldFailIfAccountNotFound() {
        UUID id = UUID.randomUUID();
        when(accountRepositoryPort.findById(id)).thenReturn(Mono.empty());
        assertThrows(AccountNotFoundException.class, () -> accountService.delete(id).block());
    }

    @Test
    void delete_shouldWorkIfAccountFound() {
        UUID id = UUID.randomUUID();
        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(validAccount()));
        when(accountRepositoryPort.deleteById(id)).thenReturn(Mono.empty());
        StepVerifier.create(accountService.delete(id))
                .verifyComplete();
        verify(accountRepositoryPort).deleteById(id);
    }


    @Test
    void getById_shouldThrowWhenAccountIdIsNull() {
        assertThrows(DomainValidationException.class, () -> accountService.getById(null).block());
    }

    @Test
    void getById_shouldThrowIfAccountNotFound() {
        UUID id = UUID.randomUUID();
        when(accountRepositoryPort.findById(id)).thenReturn(Mono.empty());
        assertThrows(AccountNotFoundException.class, () -> accountService.getById(id).block());
    }

    @Test
    void getById_shouldReturnAccountIfFound() {
        UUID id = UUID.randomUUID();
        Account account = validAccount();
        account.setId(id);
        when(accountRepositoryPort.findById(id)).thenReturn(Mono.just(account));
        StepVerifier.create(accountService.getById(id))
                .expectNext(account)
                .verifyComplete();
    }


    @Test
    void list_shouldThrowWhenPageOrSizeInvalid() {
        assertThrows(DomainValidationException.class, () -> accountService.list(UUID.randomUUID(), -1, 10).block());
        assertThrows(DomainValidationException.class, () -> accountService.list(UUID.randomUUID(), 0, 0).block());
        assertThrows(DomainValidationException.class, () -> accountService.list(UUID.randomUUID(), 0, 101).block());
    }

    @Test
    void list_shouldDelegateToRepo() {
        UUID customerId = UUID.randomUUID();
        PagedResult<Account> paged = new PagedResult<>(Collections.emptyList(), 0, 1, 0);
        when(accountRepositoryPort.findAll(customerId, 0, 1)).thenReturn(Mono.just(paged));
        StepVerifier.create(accountService.list(customerId, 0, 1))
                .expectNext(paged)
                .verifyComplete();
    }


    @Test
    void ensureDefaultsForCreate_shouldAssignIdIfNull() {
        Account acc = new Account();
        acc.setInitialBalance(BigDecimal.valueOf(100));
        Account result = invokeEnsureDefaultsForCreate(acc);
        assertNotNull(result.getId());
        assertEquals(BigDecimal.valueOf(100), result.getCurrentBalance());
    }


    @Test
    void validateForCreate_shouldReturnMonoWhenValid() {
        Account acc = validAccount();
        StepVerifier.create(invokePrivateValidateForCreate(acc))
                .expectNext(acc)
                .verifyComplete();
    }


    private Account validAccount() {
        Account a = new Account();
        a.setId(UUID.randomUUID());
        a.setCustomerId(UUID.randomUUID());
        a.setAccountNumber("A0001");
        a.setType(AccountType.SAVINGS);
        a.setInitialBalance(BigDecimal.TEN);
        a.setCurrentBalance(BigDecimal.TEN);
        a.setStatus(true);
        return a;
    }

    private CustomerResponse customerWithID(UUID id) {
        CustomerResponse c = new CustomerResponse();
        c.setId(id);
        return c;
    }

    private Account invokeEnsureDefaultsForCreate(Account acc) {
        try {
            var m = AccountServiceImpl.class.getDeclaredMethod("ensureDefaultsForCreate", Account.class);
            m.setAccessible(true);
            return (Account) m.invoke(accountService, acc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Mono<Account> invokePrivateValidateForCreate(Account acc) {
        try {
            var m = AccountServiceImpl.class.getDeclaredMethod("validateForCreate", Account.class);
            m.setAccessible(true);
            return (Mono<Account>) m.invoke(accountService, acc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Mono<Account> invokePrivateValidateAccountNumberNotDuplicated(Account acc) {
        try {
            var m = AccountServiceImpl.class.getDeclaredMethod("validateAccountNumberNotDuplicated", Account.class);
            m.setAccessible(true);
            return (Mono<Account>) m.invoke(accountService, acc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
