package com.challenge.customer_service.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void noArgsConstructorShouldCreateEmptyPerson() {
        Person person = new Person();

        assertNull(person.getName());
        assertNull(person.getGender());
        assertNull(person.getIdentification());
        assertNull(person.getAddress());
        assertNull(person.getPhone());
    }

    @Test
    void allArgsConstructorShouldSetAllFields() {
        Person person = new Person(
                "Maria",
                Gender.FEMALE,
                "987654321",
                "Calle 1",
                "555-333"
        );

        assertAll(
                () -> assertEquals("Maria", person.getName()),
                () -> assertEquals(Gender.FEMALE, person.getGender()),
                () -> assertEquals("987654321", person.getIdentification()),
                () -> assertEquals("Calle 1", person.getAddress()),
                () -> assertEquals("555-333", person.getPhone())
        );
    }

    @Test
    void settersShouldUpdateFields() {
        Person person = new Person();

        person.setName("Pedro");
        person.setGender(Gender.OTHER);
        person.setIdentification("ID-1");
        person.setAddress("Address X");
        person.setPhone("555-444");

        assertAll(
                () -> assertEquals("Pedro", person.getName()),
                () -> assertEquals(Gender.OTHER, person.getGender()),
                () -> assertEquals("ID-1", person.getIdentification()),
                () -> assertEquals("Address X", person.getAddress()),
                () -> assertEquals("555-444", person.getPhone())
        );
    }

    @Test
    void builderShouldCreatePersonWithExpectedValues() {
        Person person = Person.builder()
                .name("Sofia")
                .gender(Gender.FEMALE)
                .identification("ID-999")
                .address("Street Y")
                .phone("555-555")
                .build();

        assertAll(
                () -> assertEquals("Sofia", person.getName()),
                () -> assertEquals(Gender.FEMALE, person.getGender()),
                () -> assertEquals("ID-999", person.getIdentification()),
                () -> assertEquals("Street Y", person.getAddress()),
                () -> assertEquals("555-555", person.getPhone())
        );
    }
}
