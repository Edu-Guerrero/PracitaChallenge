package com.challenge.accounts_movements_service.application.output.port;

import com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean.CustomerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.UUID;

public interface CustomerRepositoryPort {
    Mono<CustomerResponse> getCustomerById(ServerWebExchange exchange, UUID customerId);
}