package com.challenge.customer_service.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void noArgsConstructorShouldCreateEmptyCustomer() {
        Customer customer = new Customer();

        assertNull(customer.getId());
        assertNull(customer.getPerson());
        assertNull(customer.getPasswordHash());
        assertFalse(customer.isStatus(), "Default boolean value should be false");
    }

    @Test
    void allArgsConstructorShouldSetAllFields() {
        UUID id = UUID.randomUUID();
        Person person = Person.builder()
                .name("Ana")
                .gender(Gender.FEMALE)
                .identification("123456789")
                .address("Main St 123")
                .phone("555-111")
                .build();

        Customer customer = new Customer(id, person, "hash", true);

        assertAll(
                () -> assertEquals(id, customer.getId()),
                () -> assertEquals(person, customer.getPerson()),
                () -> assertEquals("hash", customer.getPasswordHash()),
                () -> assertTrue(customer.isStatus())
        );
    }

    @Test
    void settersShouldUpdateFields() {
        Customer customer = new Customer();

        UUID id = UUID.randomUUID();
        Person person = new Person();
        person.setName("Carlos");

        customer.setId(id);
        customer.setPerson(person);
        customer.setPasswordHash("hash2");
        customer.setStatus(true);

        assertAll(
                () -> assertEquals(id, customer.getId()),
                () -> assertEquals(person, customer.getPerson()),
                () -> assertEquals("hash2", customer.getPasswordHash()),
                () -> assertTrue(customer.isStatus())
        );
    }

    @Test
    void builderShouldCreateCustomerWithExpectedValues() {
        UUID id = UUID.randomUUID();
        Person person = Person.builder()
                .name("Luis")
                .gender(Gender.MALE)
                .identification("ABC123")
                .address("Av. Siempre Viva 742")
                .phone("555-222")
                .build();

        Customer customer = Customer.builder()
                .id(id)
                .person(person)
                .passwordHash("ph")
                .status(false)
                .build();

        assertAll(
                () -> assertEquals(id, customer.getId()),
                () -> assertEquals(person, customer.getPerson()),
                () -> assertEquals("ph", customer.getPasswordHash()),
                () -> assertFalse(customer.isStatus())
        );
    }
}