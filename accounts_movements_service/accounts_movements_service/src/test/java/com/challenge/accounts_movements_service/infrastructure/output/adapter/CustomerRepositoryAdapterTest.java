package com.challenge.accounts_movements_service.infrastructure.output.adapter;

import com.challenge.accounts_movements_service.domain.exception.CustomerNotFoundException;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.CustomersApi;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CustomerRepositoryAdapterTest {

    private CustomersApi customersApi;
    private CustomerRepositoryAdapter adapter;
    private ServerWebExchange exchange;

    @BeforeEach
    void setUp() {
        customersApi = mock(CustomersApi.class);
        adapter = new CustomerRepositoryAdapter(customersApi);
        exchange = mock(ServerWebExchange.class);
    }

    @Test
    void getCustomerById_shouldReturnCustomerResponse() {
        UUID id = UUID.randomUUID();
        CustomerResponse response = new CustomerResponse();
        response.setId(id);

        when(customersApi.getCustomerById(id)).thenReturn(Mono.just(response));

        StepVerifier.create(adapter.getCustomerById(exchange, id))
                .expectNextMatches(r -> r.getId().equals(id))
                .verifyComplete();
    }

    @Test
    void getCustomerById_shouldMapNotFoundToDomainException() {
        UUID id = UUID.randomUUID();
        when(customersApi.getCustomerById(id))
                .thenReturn(Mono.error(
                        WebClientResponseException.create(404, "Not Found", null, null, null)
                ));

        StepVerifier.create(adapter.getCustomerById(exchange, id))
                .expectErrorSatisfies(th -> {
                    assertTrue(th instanceof CustomerNotFoundException);
                })
                .verify();
    }
}
