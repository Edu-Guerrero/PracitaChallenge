package com.challenge.accounts_movements_service.infrastructure.output.adapter;

import com.challenge.accounts_movements_service.application.output.port.MovementRepositoryPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper.MovementJpaMapper;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.repository.MovementJpaRepository;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@Component
public class MovementRepositoryAdapter implements MovementRepositoryPort {

    private final MovementJpaRepository movementJpaRepository;
    private final MovementJpaMapper movementJpaMapper;

    @Override
    public Mono<Movement> save(Movement movement) {
        return Mono.fromCallable(() -> movementJpaRepository.save(movementJpaMapper.toEntity(movement)))
                .subscribeOn(Schedulers.boundedElastic())
                .map(movementJpaMapper::toDomain);
    }

    @Override
    public Mono<Movement> findById(UUID movementId) {
        return Mono.fromCallable(() -> movementJpaRepository.findById(movementId).orElse(null))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(e -> e == null ? Mono.empty() : Mono.just(movementJpaMapper.toDomain(e)));
    }

    @Override
    public Mono<Void> deleteById(UUID movementId) {
        return Mono.fromRunnable(() -> movementJpaRepository.deleteById(movementId))
                .subscribeOn(Schedulers.boundedElastic())
                .then();
    }

    @Override
    public Mono<PagedResult<Movement>> findAll(UUID accountId,
                                               LocalDate startDate,
                                               LocalDate endDate,
                                               int page,
                                               int size) {
        return Mono.fromCallable(() -> {
                    var pageable = PageRequest.of(page, size);

                    var resultPage =
                            (accountId == null)
                                    ? movementJpaRepository.findAll(pageable)
                                    : (startDate != null && endDate != null)
                                    ? movementJpaRepository.findAllByAccountIdAndDateBetween(accountId, startDate, endDate, pageable)
                                    : movementJpaRepository.findAllByAccountId(accountId, pageable);

                    var content = resultPage.getContent().stream()
                            .map(movementJpaMapper::toDomain)
                            .toList();

                    return new PagedResult<>(
                            content,
                            resultPage.getNumber(),
                            resultPage.getSize(),
                            resultPage.getTotalElements()
                    );
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Flux<Movement> findByAccountIdAndDateRange(UUID accountId, LocalDate startDate, LocalDate endDate) {
        return Mono.fromCallable(() ->
                        movementJpaRepository.findAllByAccountIdAndDateBetween(accountId, startDate, endDate)
                                .stream()
                                .map(movementJpaMapper::toDomain)
                                .toList()
                )
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable);
    }
}
