package com.challenge.customer_service.infrastructure.output.adapter.mapper;

import com.challenge.customer_service.domain.model.Customer;
import com.challenge.customer_service.domain.model.Gender;
import com.challenge.customer_service.domain.model.Person;
import com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntity;
import com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerJpaMapperTest {

    @Test
    void toDomainShouldReturnNullWhenEntityIsNull() {
        assertNull(CustomerJpaMapper.toDomain(null));
    }

    @Test
    void toEntityShouldReturnNullWhenDomainIsNull() {
        assertNull(CustomerJpaMapper.toEntity(null));
    }

    @Test
    void toDomainShouldMapAllFields() {
        UUID id = UUID.randomUUID();

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(id);
        personEntity.setName("Ana");
        personEntity.setGender(Gender.FEMALE);
        personEntity.setIdentification("ID-1");
        personEntity.setAddress("Street 1");
        personEntity.setPhone("555-000");

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(id);
        customerEntity.setPerson(personEntity);
        customerEntity.setPasswordHash("hash");
        customerEntity.setStatus(true);

        Customer domain = CustomerJpaMapper.toDomain(customerEntity);

        assertNotNull(domain);
        assertAll(
                () -> assertEquals(id, domain.getId()),
                () -> assertNotNull(domain.getPerson()),
                () -> assertEquals("Ana", domain.getPerson().getName()),
                () -> assertEquals(Gender.FEMALE, domain.getPerson().getGender()),
                () -> assertEquals("ID-1", domain.getPerson().getIdentification()),
                () -> assertEquals("Street 1", domain.getPerson().getAddress()),
                () -> assertEquals("555-000", domain.getPerson().getPhone()),
                () -> assertEquals("hash", domain.getPasswordHash()),
                () -> assertTrue(domain.isStatus())
        );
    }

    @Test
    void toEntityShouldMapPersonAndCustomerFieldsAndSetPersonIdFromDomainId() {
        UUID id = UUID.randomUUID();

        Customer domain = Customer.builder()
                .id(id)
                .person(Person.builder()
                        .name("Carlos")
                        .gender(Gender.MALE)
                        .identification("ID-9")
                        .address("Addr")
                        .phone("555")
                        .build())
                .passwordHash("ph")
                .status(false)
                .build();

        CustomerEntity entity = CustomerJpaMapper.toEntity(domain);

        assertNotNull(entity);
        assertNotNull(entity.getPerson(), "PersonEntity must be created");

        assertAll(
                () -> assertNull(entity.getId(), "CustomerEntity id is not set by mapper (MapsId expects it from Person)"),
                () -> assertEquals(id, entity.getPerson().getId()),
                () -> assertEquals("Carlos", entity.getPerson().getName()),
                () -> assertEquals(Gender.MALE, entity.getPerson().getGender()),
                () -> assertEquals("ID-9", entity.getPerson().getIdentification()),
                () -> assertEquals("Addr", entity.getPerson().getAddress()),
                () -> assertEquals("555", entity.getPerson().getPhone()),
                () -> assertEquals("ph", entity.getPasswordHash()),
                () -> assertFalse(entity.isStatus())
        );
    }

    @Test
    void applyToExistingEntityShouldDoNothingWhenDomainIsNull() {
        CustomerEntity target = new CustomerEntity();
        target.setPasswordHash("old");
        target.setStatus(false);

        CustomerJpaMapper.applyToExistingEntity(null, target);

        assertEquals("old", target.getPasswordHash());
        assertFalse(target.isStatus());
    }

    @Test
    void applyToExistingEntityShouldDoNothingWhenTargetIsNull() {
        Customer domain = Customer.builder()
                .id(UUID.randomUUID())
                .person(Person.builder()
                        .name("Ana")
                        .gender(Gender.FEMALE)
                        .identification("ID-1")
                        .address("Street 1")
                        .phone("555-000")
                        .build())
                .passwordHash("hash")
                .status(true)
                .build();

        assertDoesNotThrow(() -> CustomerJpaMapper.applyToExistingEntity(domain, null));
    }

    @Test
    void applyToExistingEntityShouldCreatePersonEntityWhenMissingAndCopyFields() {
        UUID targetId = UUID.randomUUID();

        Customer domain = Customer.builder()
                .id(UUID.randomUUID())
                .person(Person.builder()
                        .name("Sofia")
                        .gender(Gender.FEMALE)
                        .identification("ID-NEW")
                        .address("New Street")
                        .phone("555-999")
                        .build())
                .passwordHash("newHash")
                .status(true)
                .build();

        CustomerEntity target = new CustomerEntity();
        target.setId(targetId);
        target.setPerson(null);
        target.setPasswordHash("oldHash");
        target.setStatus(false);

        CustomerJpaMapper.applyToExistingEntity(domain, target);

        assertNotNull(target.getPerson(), "PersonEntity should be created when missing");
        assertAll(
                () -> assertEquals("newHash", target.getPasswordHash()),
                () -> assertTrue(target.isStatus()),
                () -> assertEquals(targetId, target.getPerson().getId(), "PersonEntity id should be set from target id"),
                () -> assertEquals("Sofia", target.getPerson().getName()),
                () -> assertEquals(Gender.FEMALE, target.getPerson().getGender()),
                () -> assertEquals("ID-NEW", target.getPerson().getIdentification()),
                () -> assertEquals("New Street", target.getPerson().getAddress()),
                () -> assertEquals("555-999", target.getPerson().getPhone())
        );
    }

    @Test
    void applyToExistingEntityShouldUpdateExistingPersonEntityWithoutReplacingIt() {
        UUID targetId = UUID.randomUUID();

        PersonEntity existingPerson = new PersonEntity();
        existingPerson.setId(targetId);
        existingPerson.setName("Old");

        CustomerEntity target = new CustomerEntity();
        target.setId(targetId);
        target.setPerson(existingPerson);
        target.setPasswordHash("oldHash");
        target.setStatus(false);

        Customer domain = Customer.builder()
                .id(UUID.randomUUID())
                .person(Person.builder()
                        .name("New Name")
                        .gender(Gender.OTHER)
                        .identification("ID-X")
                        .address("Addr X")
                        .phone("555-X")
                        .build())
                .passwordHash("newHash")
                .status(true)
                .build();

        CustomerJpaMapper.applyToExistingEntity(domain, target);

        assertSame(existingPerson, target.getPerson(), "Mapper should not replace existing PersonEntity instance");
        assertAll(
                () -> assertEquals("newHash", target.getPasswordHash()),
                () -> assertTrue(target.isStatus()),
                () -> assertEquals("New Name", target.getPerson().getName()),
                () -> assertEquals(Gender.OTHER, target.getPerson().getGender()),
                () -> assertEquals("ID-X", target.getPerson().getIdentification()),
                () -> assertEquals("Addr X", target.getPerson().getAddress()),
                () -> assertEquals("555-X", target.getPerson().getPhone())
        );
    }
}
