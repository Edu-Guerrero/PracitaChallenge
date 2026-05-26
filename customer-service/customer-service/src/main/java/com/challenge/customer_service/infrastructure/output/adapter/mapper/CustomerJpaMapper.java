package com.challenge.customer_service.infrastructure.output.adapter.mapper;

import com.challenge.customer_service.domain.model.Customer;
import com.challenge.customer_service.domain.model.Person;
import com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntity;
import com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntity;

import java.util.UUID;

public class CustomerJpaMapper {
    private CustomerJpaMapper() {}

    public static Customer toDomain(CustomerEntity customerEntity) {
        if (customerEntity == null) return null;

        PersonEntity personEntity = customerEntity.getPerson();
        Person person = Person.builder()
                .name(personEntity.getName())
                .gender(personEntity.getGender())
                .identification(personEntity.getIdentification())
                .address(personEntity.getAddress())
                .phone(personEntity.getPhone())
                .build();

        return Customer.builder()
                .id(customerEntity.getId())
                .person(person)
                .passwordHash(customerEntity.getPasswordHash())
                .status(customerEntity.isStatus())
                .build();
    }

    public static CustomerEntity toEntity(Customer customer) {
        if (customer == null) return null;

        UUID id = customer.getId();

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(id);
        personEntity.setName(customer.getPerson().getName());
        personEntity.setGender(customer.getPerson().getGender());
        personEntity.setIdentification(customer.getPerson().getIdentification());
        personEntity.setAddress(customer.getPerson().getAddress());
        personEntity.setPhone(customer.getPerson().getPhone());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setPerson(personEntity);
        customerEntity.setPasswordHash(customer.getPasswordHash());
        customerEntity.setStatus(customer.isStatus());

        return customerEntity;
    }

    public static void applyToExistingEntity(Customer domain, CustomerEntity target) {
        if (domain == null || target == null) return;

        target.setPasswordHash(domain.getPasswordHash());
        target.setStatus(domain.isStatus());

        PersonEntity pe = target.getPerson();
        if (pe == null) {
            pe = new PersonEntity();
            pe.setId(target.getId());
            target.setPerson(pe);
        }

        pe.setName(domain.getPerson().getName());
        pe.setGender(domain.getPerson().getGender());
        pe.setIdentification(domain.getPerson().getIdentification());
        pe.setAddress(domain.getPerson().getAddress());
        pe.setPhone(domain.getPerson().getPhone());
    }
}
