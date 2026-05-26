package com.challenge.accounts_movements_service.application.input.port;

import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

public interface MovementInputPort {
    Mono<Movement> create(Movement movement);
    Mono<Movement> update(UUID movementId, Movement movement);
    Mono<Void> delete(UUID movementId);
    Mono<Movement> getById(UUID movementId);
    Mono<PagedResult<Movement>> list(UUID accountId, LocalDate startDate, LocalDate endDate, int page, int size);
}