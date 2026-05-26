package com.challenge.accounts_movements_service.application.output.port;

import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.Movement;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.UUID;

public interface MovementRepositoryPort {
    Mono<Movement> save(Movement movement);
    Mono<Movement> findById(UUID movementId);
    Mono<Void> deleteById(UUID movementId);

    Mono<PagedResult<Movement>> findAll(UUID accountId, LocalDate startDate, LocalDate endDate, int page, int size);

    Flux<Movement> findByAccountIdAndDateRange(UUID accountId, LocalDate startDate, LocalDate endDate);
}