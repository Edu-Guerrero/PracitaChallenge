package com.challenge.accounts_movements_service.infrastructure.output.adapter;

import com.challenge.accounts_movements_service.application.output.port.CustomerRepositoryPort;
import com.challenge.accounts_movements_service.domain.exception.CustomerNotFoundException;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.CustomersApi;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean.CustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerRepositoryAdapter implements CustomerRepositoryPort {

    private final CustomersApi customersApi;

    @Override
    public Mono<CustomerResponse> getCustomerById(ServerWebExchange exchange, UUID customerId) {
        return customersApi.getCustomerById(customerId)
                .onErrorResume(WebClientResponseException.NotFound.class, e -> Mono.error(new CustomerNotFoundException(customerId)));
    }
}
