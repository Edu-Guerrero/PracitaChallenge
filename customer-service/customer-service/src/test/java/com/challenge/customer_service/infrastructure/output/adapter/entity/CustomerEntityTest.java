package com.challenge.customer_service.infrastructure.output.adapter.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.challenge.customer_service.domain.model.Gender;

class CustomerEntityTest {

    @Test
    void noArgsConstructorShouldCreateEmptyCustomerEntity() {
        CustomerEntity entity = new CustomerEntity();

        assertNull(entity.getId());
        assertNull(entity.getPerson());
        assertNull(entity.getPasswordHash());
        assertFalse(entity.isStatus(), "Default boolean should be false");
    }

    @Test
    void settersAndGettersShouldWorkForCustomerEntity() {
        UUID id = UUID.randomUUID();

        PersonEntity person = new PersonEntity();
        person.setId(id);
        person.setName("Ana");
        person.setGender(Gender.FEMALE);
        person.setIdentification("ID-1");
        person.setAddress("Street 1");
        person.setPhone("555-000");

        CustomerEntity entity = new CustomerEntity();
        entity.setId(id);
        entity.setPerson(person);
        entity.setPasswordHash("hash");
        entity.setStatus(true);

        assertAll(
                () -> assertEquals(id, entity.getId()),
                () -> assertEquals(person, entity.getPerson()),
                () -> assertEquals("hash", entity.getPasswordHash()),
                () -> assertTrue(entity.isStatus())
        );
    }

    @Test
    void customerAndPersonShouldShareSameIdWhenUsingMapsIdSemantics() {
        UUID id = UUID.randomUUID();

        PersonEntity person = new PersonEntity();
        person.setId(id);

        CustomerEntity customer = new CustomerEntity();
        customer.setId(id);
        customer.setPerson(person);

        assertEquals(customer.getId(), customer.getPerson().getId());
    }
}
