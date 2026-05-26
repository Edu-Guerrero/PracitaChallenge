package com.challenge.accounts_movements_service.application.service.impl;

import com.challenge.accounts_movements_service.application.output.port.AccountRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.MovementRepositoryPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.exception.AccountNotFoundException;
import com.challenge.accounts_movements_service.domain.exception.DomainValidationException;
import com.challenge.accounts_movements_service.domain.exception.MovementNotFoundException;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.domain.model.MovementType;
import com.challenge.accounts_movements_service.domain.policy.MovementPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovementServiceImplTest {

    private AccountRepositoryPort accountRepositoryPort;
    private MovementRepositoryPort movementRepositoryPort;
    private MovementPolicy movementPolicy;
    private MovementServiceImpl movementService;

    @BeforeEach
    void setup() {
        accountRepositoryPort = mock(AccountRepositoryPort.class);
        movementRepositoryPort = mock(MovementRepositoryPort.class);
        movementPolicy = mock(MovementPolicy.class);
        movementService = new MovementServiceImpl(accountRepositoryPort, movementRepositoryPort, movementPolicy);
    }

    // ------------ CREATE ------------

    @Test
    void create_shouldThrowWhenMovementIsNull() {
        Mono<Movement> result = movementService.create(null);
        assertThrows(DomainValidationException.class, result::block);
    }

    @Test
    void create_shouldThrowWhenAccountIdIsNull() {
        Movement m = validMovement();
        m.setAccountId(null);
        assertThrows(DomainValidationException.class, () -> movementService.create(m).block());
    }

    @Test
    void create_shouldThrowWhenDateIsNull() {
        Movement m = validMovement();
        m.setDate(null);
        assertThrows(DomainValidationException.class, () -> movementService.create(m).block());
    }

    @Test
    void create_shouldThrowWhenTypeIsNull() {
        Movement m = validMovement();
        m.setType(null);
        assertThrows(DomainValidationException.class, () -> movementService.create(m).block());
    }

    @Test
    void create_shouldThrowWhenValueIsNull() {
        Movement m = validMovement();
        m.setValue(null);
        assertThrows(DomainValidationException.class, () -> movementService.create(m).block());
    }

    @Test
    void create_shouldThrowWhenValueIsZeroOrNegative() {
        Movement m = validMovement();
        m.setValue(BigDecimal.ZERO);
        assertThrows(DomainValidationException.class, () -> movementService.create(m).block());
        m.setValue(BigDecimal.valueOf(-1));
        assertThrows(DomainValidationException.class, () -> movementService.create(m).block());
    }

    @Test
    void create_shouldThrowIfAccountNotFound() {
        Movement m = validMovement();
        when(accountRepositoryPort.findById(m.getAccountId())).thenReturn(Mono.empty());
        assertThrows(AccountNotFoundException.class, () -> movementService.create(m).block());
    }

    @Test
    void create_shouldPersistWhenValid() {
        Movement movement = validMovement();
        Account account = validAccountWithId(movement.getAccountId());
        when(accountRepositoryPort.findById(movement.getAccountId())).thenReturn(Mono.just(account));
        when(movementPolicy.calculateNewBalance(any(), any(), any())).thenReturn(BigDecimal.valueOf(77));
        when(movementRepositoryPort.save(any())).thenReturn(Mono.just(movement));
        when(accountRepositoryPort.save(any())).thenReturn(Mono.just(account));
        Mono<Movement> result = movementService.create(movement);
        StepVerifier.create(result)
                .expectNext(movement)
                .verifyComplete();
        verify(movementRepositoryPort).save(any());
        verify(accountRepositoryPort).save(any());
    }

    // ------------ UPDATE ------------

    @Test
    void update_shouldThrowIfMovementIdIsNull() {
        assertThrows(DomainValidationException.class, () -> movementService.update(null, validMovement()).block());
    }

    @Test
    void update_shouldThrowIfIncomingMovementIsNull() {
        UUID id = UUID.randomUUID();
        assertThrows(DomainValidationException.class, () -> movementService.update(id, null).block());
    }

    @Test
    void update_shouldThrowIfMovementNotFound() {
        UUID id = UUID.randomUUID();
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.empty());
        assertThrows(MovementNotFoundException.class, () -> movementService.update(id, validMovement()).block());
    }

    @Test
    void update_shouldThrowIfAccountIdChanged() {
        UUID id = UUID.randomUUID();
        Movement existing = validMovement();
        Movement incoming = validMovement();
        incoming.setAccountId(UUID.randomUUID());
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        assertThrows(DomainValidationException.class, () -> movementService.update(id, incoming).block());
    }

    @Test
    void update_shouldThrowIfDateIsNull() {
        UUID id = UUID.randomUUID();
        Movement existing = validMovement();
        Movement incoming = validMovement();
        incoming.setDate(null);
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        assertThrows(DomainValidationException.class, () -> movementService.update(id, incoming).block());
    }

    @Test
    void update_shouldThrowIfTypeIsNull() {
        UUID id = UUID.randomUUID();
        Movement existing = validMovement();
        Movement incoming = validMovement();
        incoming.setType(null);
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        assertThrows(DomainValidationException.class, () -> movementService.update(id, incoming).block());
    }

    @Test
    void update_shouldThrowIfValueIsNullOrNonPositive() {
        UUID id = UUID.randomUUID();
        Movement existing = validMovement();
        Movement incoming = validMovement();
        incoming.setValue(null);
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        assertThrows(DomainValidationException.class, () -> movementService.update(id, incoming).block());

        incoming.setValue(BigDecimal.ZERO);
        assertThrows(DomainValidationException.class, () -> movementService.update(id, incoming).block());

        incoming.setValue(BigDecimal.valueOf(-100));
        assertThrows(DomainValidationException.class, () -> movementService.update(id, incoming).block());
    }

    @Test
    void update_shouldWorkWhenValid() {
        UUID id = UUID.randomUUID();
        Movement existing = validMovement();
        Movement incoming = validMovement();
        incoming.setAccountId(existing.getAccountId()); // no cambia
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(movementRepositoryPort.save(any())).thenReturn(Mono.just(incoming));

        StepVerifier.create(movementService.update(id, incoming))
                .expectNext(incoming)
                .verifyComplete();
        verify(movementRepositoryPort).save(any());
    }

    // ------------ DELETE ------------

    @Test
    void delete_shouldThrowWhenMovementIdIsNull() {
        assertThrows(DomainValidationException.class, () -> movementService.delete(null).block());
    }

    @Test
    void delete_shouldThrowWhenNotFound() {
        UUID id = UUID.randomUUID();
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.empty());
        assertThrows(MovementNotFoundException.class, () -> movementService.delete(id).block());
    }

    @Test
    void delete_shouldSucceed() {
        UUID id = UUID.randomUUID();
        Movement existing = validMovement();
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(movementRepositoryPort.deleteById(id)).thenReturn(Mono.empty());
        StepVerifier.create(movementService.delete(id))
                .verifyComplete();
        verify(movementRepositoryPort).deleteById(id);
    }

    // ------------ GET BY ID ------------

    @Test
    void getById_shouldThrowWhenMovementIdIsNull() {
        assertThrows(DomainValidationException.class, () -> movementService.getById(null).block());
    }

    @Test
    void getById_shouldThrowWhenNotFound() {
        UUID id = UUID.randomUUID();
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.empty());
        assertThrows(MovementNotFoundException.class, () -> movementService.getById(id).block());
    }

    @Test
    void getById_shouldSucceedWhenFound() {
        UUID id = UUID.randomUUID();
        Movement m = validMovement();
        when(movementRepositoryPort.findById(id)).thenReturn(Mono.just(m));
        StepVerifier.create(movementService.getById(id))
                .expectNext(m)
                .verifyComplete();
    }

    // ------------ LIST ------------

    @Test
    void list_shouldThrowWhenPageOrSizeInvalid() {
        UUID aid = UUID.randomUUID();
        assertThrows(DomainValidationException.class, () -> movementService.list(aid, null, null, -1, 10).block());
        assertThrows(DomainValidationException.class, () -> movementService.list(aid, null, null, 0, 0).block());
        assertThrows(DomainValidationException.class, () -> movementService.list(aid, null, null, 0, 101).block());
    }

    @Test
    void list_shouldDelegateToRepository() {
        UUID aid = UUID.randomUUID();
        PagedResult<Movement> pageResult = new PagedResult<>(Collections.emptyList(), 0, 1, 0);
        when(movementRepositoryPort.findAll(aid, null, null, 0, 1)).thenReturn(Mono.just(pageResult));
        StepVerifier.create(movementService.list(aid, null, null, 0, 1))
                .expectNext(pageResult)
                .verifyComplete();
        verify(movementRepositoryPort).findAll(aid, null, null, 0, 1);
    }

    // ------------ HELPERS ------------

    private Movement validMovement() {
        Movement m = new Movement();
        m.setId(UUID.randomUUID());
        m.setAccountId(UUID.randomUUID());
        m.setDate(LocalDate.now());
        m.setType(MovementType.CREDIT);
        m.setValue(BigDecimal.valueOf(100));
        m.setBalanceAfter(BigDecimal.valueOf(200));
        return m;
    }

    private Account validAccountWithId(UUID id) {
        Account acc = new Account();
        acc.setId(id);
        acc.setCurrentBalance(BigDecimal.valueOf(200));
        acc.setStatus(true);
        return acc;
    }
}
