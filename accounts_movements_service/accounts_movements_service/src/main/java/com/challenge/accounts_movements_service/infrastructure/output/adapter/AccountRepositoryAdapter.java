package com.challenge.accounts_movements_service.infrastructure.output.adapter;

import com.challenge.accounts_movements_service.application.output.port.AccountRepositoryPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper.AccountJpaMapper;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.repository.AccountJpaRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@Component
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountJpaRepository accountJpaRepository;
    private final AccountJpaMapper accountJpaMapper;

    @Override
    public Mono<Account> save(Account account) {
        return Mono.fromCallable(() -> accountJpaRepository.save(accountJpaMapper.toEntity(account)))
                .subscribeOn(Schedulers.boundedElastic())
                .map(accountJpaMapper::toDomain);
    }

    @Override
    public Mono<Account> findById(UUID accountId) {
        return Mono.fromCallable(() -> accountJpaRepository.findById(accountId).orElse(null))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(e -> e == null ? Mono.empty() : Mono.just(accountJpaMapper.toDomain(e)));
    }

    @Override
    public Mono<Void> deleteById(UUID accountId) {
        return Mono.fromRunnable(() -> accountJpaRepository.deleteById(accountId))
                .subscribeOn(Schedulers.boundedElastic())
                .then();
    }

    @Override
    public Mono<Boolean> existsByAccountNumber(String accountNumber) {
        return Mono.fromCallable(() -> accountJpaRepository.existsByAccountNumber(accountNumber))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<PagedResult<Account>> findAll(UUID customerId, int page, int size) {
        return Mono.fromCallable(() -> {
                    var pageable = PageRequest.of(page, size);

                    var resultPage = (customerId == null)
                            ? accountJpaRepository.findAll(pageable)
                            : accountJpaRepository.findAllByCustomerId(customerId, pageable);

                    var content = resultPage.getContent().stream()
                            .map(accountJpaMapper::toDomain)
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
}