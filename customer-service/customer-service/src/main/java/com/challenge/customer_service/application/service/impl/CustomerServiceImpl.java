package com.challenge.customer_service.application.service.impl;

import com.challenge.customer_service.application.input.port.CustomerInputPort;
import com.challenge.customer_service.application.output.port.CustomerRepositoryPort;
import com.challenge.customer_service.application.output.port.PasswordHasherPort;
import com.challenge.customer_service.application.util.PagedResult;
import com.challenge.customer_service.domain.exception.CustomerNotFoundException;
import com.challenge.customer_service.domain.exception.DomainValidationException;
import com.challenge.customer_service.domain.exception.DuplicatedIdentificationException;
import com.challenge.customer_service.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

import static com.challenge.customer_service.application.util.Constants.*;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerInputPort {

    private final CustomerRepositoryPort customerRepositoryPort;
    private final PasswordHasherPort passwordHasherPort;

    @Override
    public Mono<Customer> create(Customer customer) {
        return validateForCreate(customer)
                .then(Mono.defer(() ->
                        customerRepositoryPort
                                .existsByIdentification(customer.getPerson().getIdentification())
                                .flatMap(exists -> Boolean.TRUE.equals(exists)
                                        ? Mono.error(new DuplicatedIdentificationException(
                                        customer.getPerson().getIdentification()))
                                        : Mono.just(customer)
                                )
                ))
                .flatMap(c -> passwordHasherPort.hash(c.getPasswordHash())
                        .map(hash -> {
                            c.setPasswordHash(hash);
                            c.setId(UUID.randomUUID());
                            return c;
                        })
                )
                .flatMap(customerRepositoryPort::save);
    }

    @Override
    public Mono<Customer> getById(UUID customerId) {
        return customerRepositoryPort.findById(customerId)
                .switchIfEmpty(Mono.error(new CustomerNotFoundException(customerId)));
    }

    @Override
    public Mono<PagedResult<Customer>> list(int page, int size) {
        if (page < 0) {
            return Mono.error(new DomainValidationException(PAGE_LENGTH));
        }
        if (size < 1 || size > 100) {
            return Mono.error(new DomainValidationException(SIZE_LENGTH));
        }
        return customerRepositoryPort.findAll(page, size);
    }

    @Override
    public Mono<Customer> update(UUID customerId, Customer customer) {
        return validateForUpdate(customer)
                .then(Mono.defer(() ->
                        customerRepositoryPort.findById(customerId)
                                .switchIfEmpty(Mono.error(new CustomerNotFoundException(customerId)))
                ))
                .flatMap(existing -> {
                    String newIdentification = customer.getPerson().getIdentification();
                    String oldIdentification = existing.getPerson().getIdentification();

                    Mono<Void> uniquenessCheck = Objects.equals(oldIdentification, newIdentification)
                            ? Mono.empty()
                            : customerRepositoryPort.existsByIdentification(newIdentification)
                            .flatMap(exists -> {
                                if (Boolean.TRUE.equals(exists)) {
                                    return Mono.error(new DuplicatedIdentificationException(newIdentification));
                                } else {
                                    return Mono.empty();
                                }
                            });

                    return uniquenessCheck.thenReturn(existing);
                })
                .flatMap(ignored -> passwordHasherPort.hash(customer.getPasswordHash()))
                .map(hash -> {
                    customer.setId(customerId);
                    customer.setPasswordHash(hash);
                    return customer;
                })
                .flatMap(customerRepositoryPort::update);
    }

    @Override
    public Mono<Void> delete(UUID customerId) {
        return customerRepositoryPort.findById(customerId)
                .switchIfEmpty(Mono.error(new CustomerNotFoundException(customerId)))
                .flatMap(customer -> customerRepositoryPort.deleteById(customerId));
    }

    private Mono<Void> validateForCreate(Customer customer) {
        return validateCommon(customer);
    }

    private Mono<Void> validateForUpdate(Customer customer) {
        return validateCommon(customer);
    }

    private Mono<Void> validateCommon(Customer customer) {
        if (customer == null) return Mono.error(new DomainValidationException(CUSTOMER_REQUIRED));
        if (customer.getPerson() == null) return Mono.error(new DomainValidationException(PERSON_REQUIRED));
        if (isBlank(customer.getPerson().getName())) return Mono.error(new DomainValidationException(NAME_REQUIRED));
        if (customer.getPerson().getGender() == null) return Mono.error(new DomainValidationException(GENDER_REQUIRED));
        if (isBlank(customer.getPerson().getIdentification())) return Mono.error(new DomainValidationException(IDENTIFICATION_REQUIRED));
        if (isBlank(customer.getPerson().getAddress())) return Mono.error(new DomainValidationException(ADDRESS_REQUIRED));
        if (isBlank(customer.getPerson().getPhone())) return Mono.error(new DomainValidationException(PHONE_REQUIRED));
        if (isBlank(customer.getPasswordHash())) return Mono.error(new DomainValidationException(PASSWORD_REQUIRED));
        return Mono.empty();
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
