package com.challenge.accounts_movements_service.application.service.impl;

import com.challenge.accounts_movements_service.application.input.port.MovementInputPort;
import com.challenge.accounts_movements_service.application.output.port.AccountRepositoryPort;
import com.challenge.accounts_movements_service.application.output.port.MovementRepositoryPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.exception.AccountNotFoundException;
import com.challenge.accounts_movements_service.domain.exception.DomainValidationException;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.domain.policy.MovementPolicy;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementInputPort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final MovementRepositoryPort movementRepositoryPort;
    private final MovementPolicy movementPolicy;

    @Override
    public Mono<Movement> create(Movement movement) {
        return Mono.justOrEmpty(movement)
                .switchIfEmpty(Mono.error(new DomainValidationException("movement is required")))
                .flatMap(this::validateForCreate)
                .flatMap(mv ->
                        accountRepositoryPort.findById(mv.getAccountId())
                                .switchIfEmpty(Mono.error(new AccountNotFoundException(mv.getAccountId())))
                                .flatMap(account -> applyBusinessRulesAndPersist(account, mv))
                );
    }

    @Override
    public Mono<Movement> update(UUID movementId, Movement movement) {
        if (movementId == null) {
            return Mono.error(new DomainValidationException("movementId is required"));
        }
        return Mono.justOrEmpty(movement)
                .switchIfEmpty(Mono.error(new DomainValidationException("movement is required")))
                .flatMap(mv -> movementRepositoryPort.findById(movementId)
                        .switchIfEmpty(Mono.error(new com.challenge.accounts_movements_service.domain.exception.MovementNotFoundException(movementId)))
                        .flatMap(existing -> {
                            mv.setId(movementId);

                            if (mv.getAccountId() == null) {
                                mv.setAccountId(existing.getAccountId());
                            } else if (!mv.getAccountId().equals(existing.getAccountId())) {
                                return Mono.error(new DomainValidationException("accountId cannot be changed"));
                            }

                            return validateForUpdate(mv)
                                    .then(Mono.just(mv));
                        })
                        .flatMap(movementRepositoryPort::save)
                );
    }

    @Override
    public Mono<Void> delete(UUID movementId) {
        if (movementId == null) {
            return Mono.error(new DomainValidationException("movementId is required"));
        }

        return movementRepositoryPort.findById(movementId)
                .switchIfEmpty(Mono.error(new com.challenge.accounts_movements_service.domain.exception.MovementNotFoundException(movementId)))
                .flatMap(existing -> movementRepositoryPort.deleteById(movementId));
    }

    @Override
    public Mono<Movement> getById(UUID movementId) {
        if (movementId == null) {
            return Mono.error(new DomainValidationException("movementId is required"));
        }
        return movementRepositoryPort.findById(movementId)
                .switchIfEmpty(Mono.error(new com.challenge.accounts_movements_service.domain.exception.MovementNotFoundException(movementId)));
    }

    @Override
    public Mono<PagedResult<Movement>> list(UUID accountId, LocalDate startDate, LocalDate endDate, int page, int size) {
        if (page < 0) {
            return Mono.error(new DomainValidationException("page must be >= 0"));
        }
        if (size <= 0 || size > 100) {
            return Mono.error(new DomainValidationException("size must be between 1 and 100"));
        }

        return movementRepositoryPort.findAll(accountId, startDate, endDate, page, size);
    }


    private Mono<Movement> validateForCreate(Movement mv) {
        if (mv.getAccountId() == null) return Mono.error(new DomainValidationException("accountId is required"));
        if (mv.getDate() == null) return Mono.error(new DomainValidationException("date is required"));
        if (mv.getType() == null) return Mono.error(new DomainValidationException("type is required"));
        if (mv.getValue() == null) return Mono.error(new DomainValidationException("value is required"));

        if (mv.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            return Mono.error(new DomainValidationException("movement value must be > 0"));
        }

        return Mono.just(mv);
    }

    private Mono<Void> validateForUpdate(Movement mv) {
        if (mv.getDate() == null) return Mono.error(new DomainValidationException("date is required"));
        if (mv.getType() == null) return Mono.error(new DomainValidationException("type is required"));
        if (mv.getValue() == null) return Mono.error(new DomainValidationException("value is required"));
        if (mv.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            return Mono.error(new DomainValidationException("movement value must be > 0"));
        }
        return Mono.empty();
    }

    private Mono<Movement> applyBusinessRulesAndPersist(Account account, Movement mv) {
        if (mv.getId() == null) {
            mv.setId(UUID.randomUUID());
        }

        BigDecimal newBalance = movementPolicy.calculateNewBalance(account, mv.getType(), mv.getValue());

        account.setCurrentBalance(newBalance);

        mv.setBalanceAfter(newBalance);

        return movementRepositoryPort.save(mv)
                .flatMap(savedMovement -> accountRepositoryPort.save(account).thenReturn(savedMovement));
    }
}