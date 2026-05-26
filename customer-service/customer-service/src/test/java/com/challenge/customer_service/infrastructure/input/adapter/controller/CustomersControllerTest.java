package com.challenge.customer_service.infrastructure.input.adapter.controller;

import com.challenge.customer_service.application.input.port.CustomerInputPort;
import com.challenge.customer_service.application.util.PagedResult;
import com.challenge.customer_service.domain.model.Customer;
import com.challenge.customer_service.domain.model.Gender;
import com.challenge.customer_service.domain.model.Person;
import com.challenge.customer_service.infrastructure.input.adapter.mapper.CustomerRestMapper;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.CreateCustomerRequest;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.CustomerResponse;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.PagedCustomersResponse;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateCustomerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomersControllerTest {

    @Mock
    private CustomerInputPort customerInputPort;

    @Mock
    private CustomerRestMapper customerRestMapper;

    @Mock
    private ServerWebExchange exchange;

    private CustomersController controller;

    @BeforeEach
    void setUp() {
        controller = new CustomersController(customerInputPort, customerRestMapper);
    }

    @Test
    void createCustomerShouldMapRequestCallUseCaseAndReturn201() {
        CreateCustomerRequest req = new CreateCustomerRequest();
        req.setIdentification("ID-1");

        ServerHttpRequest httpRequest = mock(ServerHttpRequest.class);
        when(exchange.getRequest()).thenReturn(httpRequest);
        when(httpRequest.getURI()).thenReturn(URI.create("http://localhost/api/v1/customers"));

        Customer domain = validCustomer(UUID.randomUUID(), "ID-1");
        Customer saved = validCustomer(UUID.randomUUID(), "ID-1");

        CustomerResponse response = new CustomerResponse();
        response.setId(saved.getId());

        when(customerRestMapper.toDomain(req)).thenReturn(domain);
        when(customerInputPort.create(domain)).thenReturn(Mono.just(saved));
        when(customerRestMapper.toResponse(saved)).thenReturn(response);

        StepVerifier.create(controller.createCustomer(req, exchange))
                .assertNext(resp -> {
                    assertEquals(201, resp.getStatusCodeValue());
                    assertNotNull(resp.getBody());
                    assertEquals(saved.getId(), resp.getBody().getId());

                    assertNotNull(resp.getHeaders().getLocation());
                    assertEquals(
                            URI.create("http://localhost/api/v1/customers/" + saved.getId()),
                            resp.getHeaders().getLocation()
                    );
                })
                .verifyComplete();
    }

    @Test
    void getCustomerByIdShouldReturn200AndBody() {
        UUID id = UUID.randomUUID();

        Customer customer = validCustomer(id, "ID-1");
        CustomerResponse response = new CustomerResponse();
        response.setId(id);

        when(customerInputPort.getById(id)).thenReturn(Mono.just(customer));
        when(customerRestMapper.toResponse(customer)).thenReturn(response);

        StepVerifier.create(controller.getCustomerById(id, exchange))
                .assertNext(resp -> {
                    assertEquals(200, resp.getStatusCodeValue());
                    assertNotNull(resp.getBody());
                    assertEquals(id, resp.getBody().getId());
                })
                .verifyComplete();

        verify(customerInputPort).getById(id);
        verify(customerRestMapper).toResponse(customer);
    }

    @Test
    void deleteCustomerShouldCallUseCaseAndReturn204() {
        UUID id = UUID.randomUUID();

        when(customerInputPort.delete(id)).thenReturn(Mono.empty());

        StepVerifier.create(controller.deleteCustomer(id, exchange))
                .assertNext(resp -> assertEquals(204, resp.getStatusCodeValue()))
                .verifyComplete();

        verify(customerInputPort).delete(id);
    }

    @Test
    void updateCustomerShouldMapRequestCallUseCaseAndReturn200() {
        UUID id = UUID.randomUUID();
        UpdateCustomerRequest req = new UpdateCustomerRequest();

        Customer domainUpdate = validCustomer(id, "ID-NEW");
        Customer updated = validCustomer(id, "ID-NEW");

        CustomerResponse response = new CustomerResponse();
        response.setId(id);

        when(customerRestMapper.toDomain(id, req)).thenReturn(domainUpdate);
        when(customerInputPort.update(id, domainUpdate)).thenReturn(Mono.just(updated));
        when(customerRestMapper.toResponse(updated)).thenReturn(response);

        StepVerifier.create(controller.updateCustomer(id, req, exchange))
                .assertNext(resp -> {
                    assertEquals(200, resp.getStatusCodeValue());
                    assertNotNull(resp.getBody());
                    assertEquals(id, resp.getBody().getId());
                })
                .verifyComplete();

        verify(customerRestMapper).toDomain(id, req);
        verify(customerInputPort).update(id, domainUpdate);
        verify(customerRestMapper).toResponse(updated);
    }

    @Test
    void listCustomersShouldUseDefaultsWhenPageAndSizeAreNull() {
        PagedResult<Customer> paged = new PagedResult<>(
                List.of(validCustomer(UUID.randomUUID(), "ID-1")),
                0,
                20,
                1L
        );

        PagedCustomersResponse response = new PagedCustomersResponse();

        when(customerInputPort.list(0, 20)).thenReturn(Mono.just(paged));
        when(customerRestMapper.toPagedResponse(paged)).thenReturn(response);

        StepVerifier.create(controller.listCustomers(null, null, exchange))
                .assertNext(resp -> {
                    assertEquals(200, resp.getStatusCodeValue());
                    assertSame(response, resp.getBody());
                })
                .verifyComplete();

        verify(customerInputPort).list(0, 20);
        verify(customerRestMapper).toPagedResponse(paged);
    }

    @Test
    void listCustomersShouldPassProvidedPageAndSize() {
        int page = 2;
        int size = 5;

        PagedResult<Customer> paged = new PagedResult<>(
                List.of(validCustomer(UUID.randomUUID(), "ID-1")),
                page,
                size,
                1L
        );

        when(customerInputPort.list(page, size)).thenReturn(Mono.just(paged));
        when(customerRestMapper.toPagedResponse(paged)).thenReturn(new PagedCustomersResponse());

        StepVerifier.create(controller.listCustomers(page, size, exchange))
                .assertNext(resp -> assertEquals(200, resp.getStatusCodeValue()))
                .verifyComplete();

        verify(customerInputPort).list(page, size);
    }

    @Test
    void createCustomerShouldPropagateErrorFromUseCase() {
        CreateCustomerRequest req = new CreateCustomerRequest();
        req.setIdentification("ID-1");

        Customer domain = validCustomer(UUID.randomUUID(), "ID-1");
        RuntimeException ex = new RuntimeException("boom");

        when(customerRestMapper.toDomain(req)).thenReturn(domain);
        when(customerInputPort.create(domain)).thenReturn(Mono.error(ex));

        StepVerifier.create(controller.createCustomer(req, exchange))
                .expectErrorSatisfies(err -> assertSame(ex, err))
                .verify();

        verify(customerRestMapper).toDomain(req);
        verify(customerInputPort).create(domain);
        verify(customerRestMapper, never()).toResponse(any());
    }

    /**
     * Helper para crear un Customer de dominio válido.
     */
    private Customer validCustomer(UUID id, String identification) {
        Person person = Person.builder()
                .name("Ana")
                .gender(Gender.FEMALE)
                .identification(identification)
                .address("Street 1")
                .phone("555-000")
                .build();

        return Customer.builder()
                .id(id)
                .person(person)
                .passwordHash("hash")
                .status(true)
                .build();
    }
}
