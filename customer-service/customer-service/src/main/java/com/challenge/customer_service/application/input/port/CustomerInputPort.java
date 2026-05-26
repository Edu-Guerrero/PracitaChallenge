package com.challenge.customer_service.application.input.port;

import com.challenge.customer_service.application.util.PagedResult;
import com.challenge.customer_service.domain.model.Customer;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerInputPort {

    Mono<Customer> create(Customer customer);

    Mono<Customer> getById(UUID customerId);

    Mono<PagedResult<Customer>> list(int page, int size);

    Mono<Customer> update(UUID customerId, Customer customer);

    Mono<Void> delete(UUID customerId);
}
