package com.challenge.customer_service.application.service.impl;

import com.challenge.customer_service.application.output.port.CustomerRepositoryPort;
import com.challenge.customer_service.application.output.port.PasswordHasherPort;
import com.challenge.customer_service.application.util.PagedResult;
import com.challenge.customer_service.domain.exception.CustomerNotFoundException;
import com.challenge.customer_service.domain.exception.DomainValidationException;
import com.challenge.customer_service.domain.exception.DuplicatedIdentificationException;
import com.challenge.customer_service.domain.model.Customer;
import com.challenge.customer_service.domain.model.Gender;
import com.challenge.customer_service.domain.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepositoryPort customerRepositoryPort;

    @Mock
    private PasswordHasherPort passwordHasherPort;

    private CustomerServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CustomerServiceImpl(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenCustomerIsNull() {
        StepVerifier.create(service.create(null))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("customer is required", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenPersonIsNull() {
        Customer customer = Customer.builder()
                .person(null)
                .passwordHash("plain")
                .status(true)
                .build();

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("person data is required", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenNameIsBlank() {
        Customer customer = validCustomer("   ", "ID-1");

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("name must not be blank", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenGenderIsNull() {
        Customer customer = validCustomer("Ana", "ID-1");
        customer.getPerson().setGender(null);

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("gender must not be null", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenIdentificationIsBlank() {
        Customer customer = validCustomer("Ana", "   ");

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("identification must not be blank", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenAddressIsBlank() {
        Customer customer = validCustomer("Ana", "ID-1");
        customer.getPerson().setAddress(" ");

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("address must not be blank", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenPhoneIsBlank() {
        Customer customer = validCustomer("Ana", "ID-1");
        customer.getPerson().setPhone("  ");

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("phone must not be blank", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenPasswordIsBlank() {
        Customer customer = validCustomer("Ana", "ID-1");
        customer.setPasswordHash("   ");

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("password must not be blank", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void createShouldFailWhenIdentificationIsDuplicated() {
        Customer customer = validCustomer("Ana", "DUP-1");

        when(customerRepositoryPort.existsByIdentification("DUP-1"))
                .thenReturn(Mono.just(true));

        StepVerifier.create(service.create(customer))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DuplicatedIdentificationException.class, ex);
                    assertEquals("Customer with same identification already exists: DUP-1", ex.getMessage());
                })
                .verify();

        verify(customerRepositoryPort).existsByIdentification("DUP-1");
        verifyNoInteractions(passwordHasherPort);
        verify(customerRepositoryPort, never()).save(any());
    }

    @Test
    void createShouldHashPasswordAssignIdAndSave() {
        Customer customer = validCustomer("Ana", "ID-OK");
        customer.setId(null);

        when(customerRepositoryPort.existsByIdentification("ID-OK"))
                .thenReturn(Mono.just(false));
        when(passwordHasherPort.hash("plain"))
                .thenReturn(Mono.just("hashed"));
        when(customerRepositoryPort.save(any(Customer.class)))
                .thenAnswer(inv -> Mono.just(inv.getArgument(0, Customer.class)));

        StepVerifier.create(service.create(customer))
                .assertNext(saved -> {
                    assertNotNull(saved.getId(), "Service should assign a new UUID");
                    assertEquals("hashed", saved.getPasswordHash());
                    assertEquals("ID-OK", saved.getPerson().getIdentification());
                })
                .verifyComplete();

        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepositoryPort).save(captor.capture());
        assertNotNull(captor.getValue().getId());
        assertEquals("hashed", captor.getValue().getPasswordHash());
    }

    @Test
    void getByIdShouldReturnCustomerWhenExists() {
        UUID id = UUID.randomUUID();
        Customer customer = validCustomer("Ana", "ID-1");
        customer.setId(id);

        when(customerRepositoryPort.findById(id)).thenReturn(Mono.just(customer));

        StepVerifier.create(service.getById(id))
                .expectNext(customer)
                .verifyComplete();

        verify(customerRepositoryPort).findById(id);
    }

    @Test
    void getByIdShouldFailWhenCustomerDoesNotExist() {
        UUID id = UUID.randomUUID();
        when(customerRepositoryPort.findById(id)).thenReturn(Mono.empty());

        StepVerifier.create(service.getById(id))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(CustomerNotFoundException.class, ex);
                    assertEquals("Customer not found: " + id, ex.getMessage());
                })
                .verify();
    }

    @Test
    void listShouldFailWhenPageIsNegative() {
        StepVerifier.create(service.list(-1, 10))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("page must be greater than or equal to 0", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort);
    }

    @Test
    void listShouldFailWhenSizeIsOutOfRange() {
        StepVerifier.create(service.list(0, 0))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("size must be between 1 and 100", ex.getMessage());
                })
                .verify();

        StepVerifier.create(service.list(0, 101))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("size must be between 1 and 100", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort);
    }

    @Test
    void listShouldDelegateToRepositoryWhenInputIsValid() {
        PagedResult<Customer> paged = new PagedResult<>(
                List.of(validCustomer("Ana", "ID-1")),
                0,
                10,
                1L
        );

        when(customerRepositoryPort.findAll(0, 10)).thenReturn(Mono.just(paged));

        StepVerifier.create(service.list(0, 10))
                .expectNext(paged)
                .verifyComplete();

        verify(customerRepositoryPort).findAll(0, 10);
    }

    @Test
    void updateShouldFailWhenCustomerIsNull() {
        UUID id = UUID.randomUUID();

        StepVerifier.create(service.update(id, null))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DomainValidationException.class, ex);
                    assertEquals("customer is required", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerRepositoryPort, passwordHasherPort);
    }

    @Test
    void updateShouldFailWhenCustomerDoesNotExist() {
        UUID id = UUID.randomUUID();
        Customer update = validCustomer("Ana", "ID-NEW");

        when(customerRepositoryPort.findById(id)).thenReturn(Mono.empty());

        StepVerifier.create(service.update(id, update))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(CustomerNotFoundException.class, ex);
                    assertEquals("Customer not found: " + id, ex.getMessage());
                })
                .verify();

        verify(customerRepositoryPort).findById(id);
        verifyNoInteractions(passwordHasherPort);
        verify(customerRepositoryPort, never()).update(any());
    }

    @Test
    void updateShouldNotCheckUniquenessWhenIdentificationIsUnchanged() {
        UUID id = UUID.randomUUID();

        Customer existing = validCustomer("Ana", "ID-SAME");
        existing.setId(id);

        Customer update = validCustomer("Ana Updated", "ID-SAME");
        update.setPasswordHash("plainNew");

        when(customerRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(passwordHasherPort.hash("plainNew")).thenReturn(Mono.just("hashedNew"));
        when(customerRepositoryPort.update(any(Customer.class)))
                .thenAnswer(inv -> Mono.just(inv.getArgument(0, Customer.class)));

        StepVerifier.create(service.update(id, update))
                .assertNext(saved -> {
                    assertEquals(id, saved.getId());
                    assertEquals("hashedNew", saved.getPasswordHash());
                    assertEquals("ID-SAME", saved.getPerson().getIdentification());
                    assertEquals("Ana Updated", saved.getPerson().getName());
                })
                .verifyComplete();

        verify(customerRepositoryPort, never()).existsByIdentification(anyString());
        verify(customerRepositoryPort).update(any(Customer.class));
    }

    @Test
    void updateShouldFailWhenIdentificationChangedAndDuplicated() {
        UUID id = UUID.randomUUID();

        Customer existing = validCustomer("Ana", "ID-OLD");
        existing.setId(id);

        Customer update = validCustomer("Ana", "ID-DUP");
        update.setPasswordHash("plainNew");

        when(customerRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(customerRepositoryPort.existsByIdentification("ID-DUP")).thenReturn(Mono.just(true));

        StepVerifier.create(service.update(id, update))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(DuplicatedIdentificationException.class, ex);
                    assertEquals("Customer with same identification already exists: ID-DUP", ex.getMessage());
                })
                .verify();

        verify(customerRepositoryPort).existsByIdentification("ID-DUP");
        verifyNoInteractions(passwordHasherPort);
        verify(customerRepositoryPort, never()).update(any());
    }

    @Test
    void updateShouldCheckUniquenessWhenIdentificationChangedAndProceedWhenUnique() {
        UUID id = UUID.randomUUID();

        Customer existing = validCustomer("Ana", "ID-OLD");
        existing.setId(id);

        Customer update = validCustomer("Ana New", "ID-NEW");
        update.setPasswordHash("plainNew");

        when(customerRepositoryPort.findById(id)).thenReturn(Mono.just(existing));
        when(customerRepositoryPort.existsByIdentification("ID-NEW")).thenReturn(Mono.just(false));
        when(passwordHasherPort.hash("plainNew")).thenReturn(Mono.just("hashedNew"));
        when(customerRepositoryPort.update(any(Customer.class)))
                .thenAnswer(inv -> Mono.just(inv.getArgument(0, Customer.class)));

        StepVerifier.create(service.update(id, update))
                .assertNext(saved -> {
                    assertEquals(id, saved.getId());
                    assertEquals("hashedNew", saved.getPasswordHash());
                    assertEquals("ID-NEW", saved.getPerson().getIdentification());
                })
                .verifyComplete();

        verify(customerRepositoryPort).existsByIdentification("ID-NEW");
        verify(customerRepositoryPort).update(any(Customer.class));
    }

    @Test
    void deleteShouldFailWhenCustomerDoesNotExist() {
        UUID id = UUID.randomUUID();

        when(customerRepositoryPort.findById(id)).thenReturn(Mono.empty());

        StepVerifier.create(service.delete(id))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(CustomerNotFoundException.class, ex);
                    assertEquals("Customer not found: " + id, ex.getMessage());
                })
                .verify();

        verify(customerRepositoryPort, never()).deleteById(any());
    }

    @Test
    void deleteShouldDeleteWhenCustomerExists() {
        UUID id = UUID.randomUUID();

        when(customerRepositoryPort.findById(id)).thenReturn(Mono.just(validCustomer("Ana", "ID-1")));
        when(customerRepositoryPort.deleteById(id)).thenReturn(Mono.empty());

        StepVerifier.create(service.delete(id))
                .verifyComplete();

        verify(customerRepositoryPort).deleteById(id);
    }

    private Customer validCustomer(String name, String identification) {
        Person person = Person.builder()
                .name(name)
                .gender(Gender.FEMALE)
                .identification(identification)
                .address("Address 1")
                .phone("555-000")
                .build();

        return Customer.builder()
                .person(person)
                .passwordHash("plain")
                .status(true)
                .build();
    }
}
