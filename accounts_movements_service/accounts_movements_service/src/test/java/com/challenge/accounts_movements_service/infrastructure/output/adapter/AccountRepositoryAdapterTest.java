package com.challenge.accounts_movements_service.infrastructure.output.adapter;

import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.AccountType;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.AccountEntity;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper.AccountJpaMapper;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.repository.AccountJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountRepositoryAdapterTest {

    private AccountJpaRepository repository;
    private AccountRepositoryAdapter adapter;

    @Mock
    private AccountJpaMapper accountJpaMapper;

    @BeforeEach
    void setUp() {
        repository = mock(AccountJpaRepository.class);
        accountJpaMapper = mock(AccountJpaMapper.class);
        adapter = new AccountRepositoryAdapter(repository, accountJpaMapper);
    }

    @Test
    void save_shouldPersistAndReturnDomain() {
        Account domain = Account.builder()
                .id(UUID.randomUUID())
                .customerId(UUID.randomUUID())
                .accountNumber("1234")
                .type(AccountType.SAVINGS)
                .initialBalance(BigDecimal.TEN)
                .currentBalance(BigDecimal.TEN)
                .status(true)
                .build();

        AccountEntity entity = AccountEntity.builder()
                .id(domain.getId())
                .customerId(domain.getCustomerId())
                .accountNumber(domain.getAccountNumber())
                .type(domain.getType())
                .initialBalance(domain.getInitialBalance())
                .currentBalance(domain.getCurrentBalance())
                .status(domain.isStatus())
                .build();

        when(repository.save(any(AccountEntity.class))).thenReturn(entity);
        when(accountJpaMapper.toEntity(domain)).thenReturn(entity);
        when(accountJpaMapper.toDomain(entity)).thenReturn(domain);

        StepVerifier.create(adapter.save(domain))
                .expectNextMatches(acc -> acc.getAccountNumber().equals("1234"))
                .verifyComplete();

        verify(repository).save(any(AccountEntity.class));
    }

    @Test
    void findById_shouldReturnDomainAccount() {
        AccountEntity entity = AccountEntity.builder()
                .id(UUID.randomUUID())
                .customerId(UUID.randomUUID())
                .accountNumber("111")
                .type(AccountType.SAVINGS)
                .initialBalance(BigDecimal.ZERO)
                .currentBalance(BigDecimal.ZERO)
                .status(true)
                .build();

        Account domain = Account.builder()
                .id(entity.getId())
                .customerId(entity.getCustomerId())
                .accountNumber(entity.getAccountNumber())
                .type(entity.getType())
                .initialBalance(entity.getInitialBalance())
                .currentBalance(entity.getCurrentBalance())
                .status(entity.isStatus())
                .build();

        when(repository.findById(entity.getId())).thenReturn(Optional.of(entity));
        when(accountJpaMapper.toDomain(entity)).thenReturn(domain);
        StepVerifier.create(adapter.findById(entity.getId()))
                .expectNextMatches(acc -> acc.getId().equals(entity.getId()))
                .verifyComplete();
    }

    @Test
    void findById_shouldReturnEmptyWhenNotFound() {
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());
        StepVerifier.create(adapter.findById(id))
                .verifyComplete();
    }

    @Test
    void deleteById_shouldComplete() {
        UUID id = UUID.randomUUID();

        doNothing().when(repository).deleteById(id);
        StepVerifier.create(adapter.deleteById(id))
                .verifyComplete();
        verify(repository).deleteById(id);
    }

    @Test
    void existsByAccountNumber_shouldReturnBoolean() {
        when(repository.existsByAccountNumber("acc")).thenReturn(true);
        StepVerifier.create(adapter.existsByAccountNumber("acc"))
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void findAll_shouldReturnPagedResult_withoutCustomerId() {
        Page<AccountEntity> page = new PageImpl<>(List.of(AccountEntity.builder().id(UUID.randomUUID()).build()), PageRequest.of(0,1), 1);
        when(repository.findAll(any(PageRequest.class))).thenReturn(page);

        StepVerifier.create(adapter.findAll(null, 0, 1))
                .assertNext(result -> assertEquals(1, result.content().size()))
                .verifyComplete();
    }

    @Test
    void findAll_shouldReturnPagedResult_withCustomerId() {
        UUID customerId = UUID.randomUUID();
        Page<AccountEntity> page = new PageImpl<>(List.of(AccountEntity.builder().id(UUID.randomUUID()).build()), PageRequest.of(0,1), 1);
        when(repository.findAllByCustomerId(eq(customerId), any(PageRequest.class))).thenReturn(page);

        StepVerifier.create(adapter.findAll(customerId, 0, 1))
                .assertNext(result -> assertEquals(1, result.content().size()))
                .verifyComplete();
    }
}

