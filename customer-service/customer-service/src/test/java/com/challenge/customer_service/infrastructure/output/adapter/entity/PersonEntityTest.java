package com.challenge.customer_service.infrastructure.output.adapter.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.challenge.customer_service.domain.model.Gender;

class PersonEntityTest {

    @Test
    void noArgsConstructorShouldCreateEmptyPersonEntity() {
        PersonEntity entity = new PersonEntity();

        assertNull(entity.getId());
        assertNull(entity.getName());
        assertNull(entity.getGender());
        assertNull(entity.getIdentification());
        assertNull(entity.getAddress());
        assertNull(entity.getPhone());
    }

    @Test
    void settersAndGettersShouldWorkForPersonEntity() {
        UUID id = UUID.randomUUID();

        PersonEntity entity = new PersonEntity();
        entity.setId(id);
        entity.setName("Carlos");
        entity.setGender(Gender.MALE);
        entity.setIdentification("ID-777");
        entity.setAddress("Address X");
        entity.setPhone("555-123");

        assertAll(
                () -> assertEquals(id, entity.getId()),
                () -> assertEquals("Carlos", entity.getName()),
                () -> assertEquals(Gender.MALE, entity.getGender()),
                () -> assertEquals("ID-777", entity.getIdentification()),
                () -> assertEquals("Address X", entity.getAddress()),
                () -> assertEquals("555-123", entity.getPhone())
        );
    }
}
