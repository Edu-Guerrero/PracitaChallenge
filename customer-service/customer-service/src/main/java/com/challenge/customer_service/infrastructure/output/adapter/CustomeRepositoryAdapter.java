package com.challenge.customer_service.infrastructure.output.adapter;

import com.challenge.customer_service.application.output.port.CustomerRepositoryPort;
import com.challenge.customer_service.application.util.PagedResult;
import com.challenge.customer_service.domain.model.Customer;
import com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntity;
import com.challenge.customer_service.infrastructure.output.adapter.mapper.CustomerJpaMapper;
import com.challenge.customer_service.infrastructure.output.adapter.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;

import static com.challenge.customer_service.infrastructure.utils.Constants.MSG_CUSTOMER_ID_REQUIRED_FOR_UPDATE;
import static com.challenge.customer_service.infrastructure.utils.Constants.MSG_CUSTOMER_NOT_FOUND_PREFIX;

@RequiredArgsConstructor
@Component
public class CustomeRepositoryAdapter implements CustomerRepositoryPort {

    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public Mono<Customer> save(Customer customer) {
        return Mono.fromCallable(() -> customerJpaRepository.save(CustomerJpaMapper.toEntity(customer)))
                .subscribeOn(Schedulers.boundedElastic())
                .map(CustomerJpaMapper::toDomain);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return Mono.fromCallable(() -> {
                    if (customer.getId() == null) {
                        throw new IllegalArgumentException(MSG_CUSTOMER_ID_REQUIRED_FOR_UPDATE);
                    }

                    CustomerEntity existing = customerJpaRepository.findByIdWithPerson(customer.getId())
                            .orElseThrow(() -> new IllegalStateException(MSG_CUSTOMER_NOT_FOUND_PREFIX + customer.getId()));

                    // Apply changes to the managed entity (NO new entity graph)
                    CustomerJpaMapper.applyToExistingEntity(customer, existing);

                    CustomerEntity saved = customerJpaRepository.save(existing);
                    return CustomerJpaMapper.toDomain(saved);
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Customer> findById(UUID id) {
        return Mono.fromCallable(() -> customerJpaRepository.findByIdWithPerson(id).orElse(null))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(entity -> entity == null ? Mono.empty() : Mono.just(CustomerJpaMapper.toDomain(entity)));
    }

    @Override
    public Mono<Boolean> existsByIdentification(String identification) {
        return Mono.fromCallable(() -> customerJpaRepository.existsByPerson_Identification(identification))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<PagedResult<Customer>> findAll(int page, int size) {
        return Mono.fromCallable(() -> {
                    var pageable = PageRequest.of(page, size);
                    var resultPage = customerJpaRepository.findAllWithPerson(pageable);

                    var content = resultPage.getContent().stream()
                            .map(CustomerJpaMapper::toDomain)
                            .toList();

                    return new PagedResult<>(content, page, size, resultPage.getTotalElements());
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return Mono.fromRunnable(() -> customerJpaRepository.deleteById(id))
                .subscribeOn(Schedulers.boundedElastic())
                .then();
    }
}
