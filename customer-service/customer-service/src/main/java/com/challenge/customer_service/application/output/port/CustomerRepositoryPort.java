package com.challenge.customer_service.application.output.port;

import com.challenge.customer_service.application.util.PagedResult;
import com.challenge.customer_service.domain.model.Customer;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerRepositoryPort {

    Mono<Customer> save(Customer customer);

    Mono<Customer> update(Customer customer);

    Mono<Customer> findById(UUID id);

    Mono<Boolean> existsByIdentification(String identification);

    Mono<PagedResult<Customer>> findAll(int page, int size);

    Mono<Void> deleteById(UUID id);
}
