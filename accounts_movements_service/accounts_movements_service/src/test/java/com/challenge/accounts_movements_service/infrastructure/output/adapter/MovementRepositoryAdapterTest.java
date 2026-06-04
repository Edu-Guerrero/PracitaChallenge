package com.challenge.accounts_movements_service.infrastructure.output.adapter;

import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.domain.model.MovementType;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.MovementEntity;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper.MovementJpaMapper;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.repository.MovementJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MovementRepositoryAdapterTest {

    private MovementJpaRepository repository;
    private MovementRepositoryAdapter adapter;

    @Mock
    private MovementJpaMapper mapper;

    @BeforeEach
    void setUp() {
        repository = mock(MovementJpaRepository.class);
        mapper = mock(MovementJpaMapper.class);
        adapter = new MovementRepositoryAdapter(repository, mapper);
    }

    @Test
    void save_shouldPersistAndReturnDomain() {
        Movement domain = Movement.builder()
                .id(UUID.randomUUID())
                .accountId(UUID.randomUUID())
                .date(LocalDate.now())
                .type(MovementType.CREDIT)
                .value(BigDecimal.valueOf(10))
                .balanceAfter(BigDecimal.valueOf(20))
                .build();

        MovementEntity entity = MovementEntity.builder()
                .id(domain.getId())
                .accountId(domain.getAccountId())
                .date(domain.getDate())
                .type(domain.getType())
                .value(domain.getValue())
                .balanceAfter(domain.getBalanceAfter())
                .build();

        when(repository.save(any(MovementEntity.class))).thenReturn(entity);
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        StepVerifier.create(adapter.save(domain))
                .expectNextMatches(m -> m.getValue().equals(BigDecimal.valueOf(10)))
                .verifyComplete();

        verify(repository).save(any(MovementEntity.class));
    }

    @Test
    void findById_shouldReturnDomainMovement() {
        UUID id = UUID.randomUUID();
        UUID accountId = UUID.randomUUID();
        MovementEntity entity = MovementEntity.builder()
                .id(id)
                .accountId(accountId)
                .date(LocalDate.now())
                .type(MovementType.DEBIT)
                .value(BigDecimal.TEN)
                .balanceAfter(BigDecimal.ZERO)
                .build();

        Movement domain = Movement.builder()
                .id(id)
                .accountId(accountId)
                .date(entity.getDate())
                .type(entity.getType())
                .value(entity.getValue())
                .balanceAfter(entity.getBalanceAfter())
                .build();

        when(repository.findById(entity.getId())).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);
        StepVerifier.create(adapter.findById(entity.getId()))
                .expectNextMatches(m -> m.getId().equals(entity.getId()))
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
    void findAll_shouldReturnPagedResult_withoutAccountId() {
        Page<MovementEntity> page = new PageImpl<>(List.of(MovementEntity.builder().id(UUID.randomUUID()).build()), PageRequest.of(0,1), 1);
        when(repository.findAll(any(PageRequest.class))).thenReturn(page);

        StepVerifier.create(adapter.findAll(null, null, null, 0, 1))
                .assertNext(result -> assertEquals(1, result.content().size()))
                .verifyComplete();
    }

    @Test
    void findAll_shouldReturnPagedResult_withAccountId_andDates() {
        UUID accId = UUID.randomUUID();
        LocalDate d1 = LocalDate.now().minusDays(5);
        LocalDate d2 = LocalDate.now();
        Page<MovementEntity> page = new PageImpl<>(List.of(MovementEntity.builder().id(UUID.randomUUID()).build()), PageRequest.of(0,1), 1);
        when(repository.findAllByAccountIdAndDateBetween(eq(accId), eq(d1), eq(d2), any(PageRequest.class))).thenReturn(page);

        StepVerifier.create(adapter.findAll(accId, d1, d2, 0, 1))
                .assertNext(result -> assertEquals(1, result.content().size()))
                .verifyComplete();
    }

    @Test
    void findByAccountIdAndDateRange_shouldReturnFlux() {
        UUID id = UUID.randomUUID();
        UUID accId = UUID.randomUUID();
        LocalDate d1 = LocalDate.now().minusDays(2);
        LocalDate d2 = LocalDate.now();
        MovementEntity entity = MovementEntity.builder()
                .id(id)
                .accountId(accId)
                .date(d1)
                .type(MovementType.DEBIT)
                .value(BigDecimal.TEN)
                .balanceAfter(BigDecimal.ZERO)
                .build();

        Movement movement = Movement.builder()
                .id(id)
                .accountId(accId)
                .date(d1)
                .type(MovementType.DEBIT)
                .value(BigDecimal.TEN)
                .balanceAfter(BigDecimal.ZERO)
                .build();

        when(repository.findAllByAccountIdAndDateBetween(accId, d1, d2)).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(movement);

        StepVerifier.create(adapter.findByAccountIdAndDateRange(accId, d1, d2))
                .expectNextMatches(m -> m != null && m.getId().equals(id))
                .verifyComplete();
    }

}
