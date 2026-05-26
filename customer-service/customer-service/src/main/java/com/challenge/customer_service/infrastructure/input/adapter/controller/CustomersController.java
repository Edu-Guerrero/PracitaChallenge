package com.challenge.customer_service.infrastructure.input.adapter.controller;

import com.challenge.customer_service.application.input.port.CustomerInputPort;
import com.challenge.customer_service.infrastructure.input.adapter.mapper.CustomerRestMapper;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.CustomersApi;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.CreateCustomerRequest;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.CustomerResponse;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.PagedCustomersResponse;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateCustomerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

import static com.challenge.customer_service.infrastructure.utils.Constants.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomersController implements CustomersApi {

    private final CustomerInputPort customerInputPort;
    private final CustomerRestMapper customerRestMapper;

    @Override
    public Mono<ResponseEntity<CustomerResponse>> createCustomer(CreateCustomerRequest createCustomerRequest,
                                                                 ServerWebExchange exchange) {
        log.info(IN + ACTION_CREATE + "create customer with identification={}", createCustomerRequest.getIdentification());

        return Mono.fromSupplier(() -> customerRestMapper.toDomain(createCustomerRequest))
                .flatMap(customerInputPort::create)
                .map(saved -> {
                    CustomerResponse body = customerRestMapper.toResponse(saved);

                    URI location = UriComponentsBuilder
                            .fromUri(exchange.getRequest().getURI())
                            .replacePath(PATH_API_V1_CUSTOMERS + "/" + body.getId())
                            .replaceQuery(null)
                            .build(true)
                            .toUri();

                    return ResponseEntity.created(location).body(body);
                })
                .doOnSuccess(resp -> log.info(OUT + ACTION_CREATE + "customer created successfully id={}",
                        resp != null && resp.getBody() != null ? resp.getBody().getId() : null))
                .doOnError(e -> log.error(OUT + ACTION_CREATE + "error creating customer. Error: {}", e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCustomer(UUID customerId,
                                                     ServerWebExchange exchange) {
        log.info(IN + ACTION_DELETE + "delete customer with id {}", customerId);
        return customerInputPort.delete(customerId)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .doOnSuccess(message -> log.info(OUT + ACTION_DELETE + "delete customer successfully with id {}", customerId))
                .doOnError(e -> log.error(OUT + ACTION_DELETE + "Error deleting customer. Error: {}", e.getMessage()));
    }

    @Override
    public Mono<ResponseEntity<CustomerResponse>> getCustomerById(UUID customerId,
                                                                  ServerWebExchange exchange) {
        log.info(IN + ACTION_GET_BY_ID + "get customer with id {}", customerId);

        return customerInputPort.getById(customerId)
                .map(customerRestMapper::toResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_GET_BY_ID + "customer retrieved successfully id={}",
                        resp != null && resp.getBody() != null ? resp.getBody().getId() : null))
                .doOnError(e -> log.error(OUT + ACTION_GET_BY_ID + "error retrieving customer id={}. Error: {}",
                        customerId, e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<PagedCustomersResponse>> listCustomers(Integer page,
                                                                      Integer size,
                                                                      ServerWebExchange exchange) {
        int safePage = page != null ? page : 0;
        int safeSize = size != null ? size : 20;

        log.info(IN + ACTION_LIST + "list customers page={} size={}", safePage, safeSize);

        return customerInputPort.list(safePage, safeSize)
                .map(customerRestMapper::toPagedResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_LIST + "customers listed successfully page={} size={}",
                        safePage, safeSize))
                .doOnError(e -> log.error(OUT + ACTION_LIST + "error listing customers page={} size={}. Error: {}",
                        safePage, safeSize, e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<CustomerResponse>> updateCustomer(UUID customerId,
                                                                 UpdateCustomerRequest updateCustomerRequest,
                                                                 ServerWebExchange exchange) {
        log.info(IN + ACTION_UPDATE + "update customer id={}", customerId);

        return Mono.fromSupplier(() -> customerRestMapper.toDomain(customerId, updateCustomerRequest))
                .flatMap(domainCustomer -> customerInputPort.update(customerId, domainCustomer))
                .map(customerRestMapper::toResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_UPDATE + "customer updated successfully id={}",
                        resp != null && resp.getBody() != null ? resp.getBody().getId() : null))
                .doOnError(e -> log.error(OUT + ACTION_UPDATE + "error updating customer id={}. Error: {}",
                        customerId, e.getMessage(), e));
    }
}
