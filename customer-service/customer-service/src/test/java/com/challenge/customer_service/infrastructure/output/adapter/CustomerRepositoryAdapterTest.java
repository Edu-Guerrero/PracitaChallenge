package com.challenge.customer_service.infrastructure.output.adapter;

import com.challenge.customer_service.domain.model.Customer;
import com.challenge.customer_service.domain.model.Gender;
import com.challenge.customer_service.domain.model.Person;
import com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntity;
import com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntity;
import com.challenge.customer_service.infrastructure.output.adapter.repository.CustomerJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryAdapterTest {

    @Mock
    private CustomerJpaRepository customerJpaRepository;

    private CustomeRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new CustomeRepositoryAdapter(customerJpaRepository);
    }

    @Test
    void saveShouldPersistMappedEntityAndReturnDomain() {
        UUID id = UUID.randomUUID();

        Customer domain = validCustomer(id, "ID-1");
        CustomerEntity savedEntity = validCustomerEntity(id, "ID-1");

        when(customerJpaRepository.save(any(CustomerEntity.class))).thenReturn(savedEntity);

        StepVerifier.create(adapter.save(domain))
                .assertNext(saved -> {
                    assertNotNull(saved);
                    assertEquals(id, saved.getId());
                    assertEquals("ID-1", saved.getPerson().getIdentification());
                    assertEquals("hash", saved.getPasswordHash());
                })
                .verifyComplete();

        ArgumentCaptor<CustomerEntity> captor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerJpaRepository).save(captor.capture());

        CustomerEntity entityPassed = captor.getValue();
        assertNotNull(entityPassed.getPerson(), "Mapper should create person entity");
        assertEquals(id, entityPassed.getPerson().getId(), "Mapper should set person.id from domain.id");
        assertEquals("ID-1", entityPassed.getPerson().getIdentification());
    }

    @Test
    void updateShouldThrowWhenCustomerIdIsNull() {
        Customer domain = validCustomer(null, "ID-1");

        StepVerifier.create(adapter.update(domain))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(IllegalArgumentException.class, ex);
                    assertEquals("customer.id is required for update", ex.getMessage());
                })
                .verify();

        verifyNoInteractions(customerJpaRepository);
    }

    @Test
    void updateShouldThrowWhenExistingCustomerIsNotFound() {
        UUID id = UUID.randomUUID();
        Customer domain = validCustomer(id, "ID-NEW");

        when(customerJpaRepository.findByIdWithPerson(id)).thenReturn(Optional.empty());

        StepVerifier.create(adapter.update(domain))
                .expectErrorSatisfies(ex -> {
                    assertInstanceOf(IllegalStateException.class, ex);
                    assertEquals("Customer not found: " + id, ex.getMessage());
                })
                .verify();

        verify(customerJpaRepository).findByIdWithPerson(id);
        verify(customerJpaRepository, never()).save(any());
    }

    @Test
    void updateShouldApplyChangesToManagedEntityAndSave() {
        UUID id = UUID.randomUUID();

        Customer domainUpdate = validCustomer(id, "ID-NEW");
        domainUpdate.getPerson().setName("New Name");
        domainUpdate.setPasswordHash("newHash");
        domainUpdate.setStatus(false);

        CustomerEntity existing = validCustomerEntity(id, "ID-OLD");
        existing.getPerson().setName("Old Name");
        existing.setPasswordHash("oldHash");
        existing.setStatus(true);

        when(customerJpaRepository.findByIdWithPerson(id)).thenReturn(Optional.of(existing));
        when(customerJpaRepository.save(existing)).thenReturn(existing);

        StepVerifier.create(adapter.update(domainUpdate))
                .assertNext(updated -> {
                    assertEquals(id, updated.getId());
                    assertEquals("ID-NEW", updated.getPerson().getIdentification());
                    assertEquals("New Name", updated.getPerson().getName());
                    assertEquals("newHash", updated.getPasswordHash());
                    assertFalse(updated.isStatus());
                })
                .verifyComplete();

        verify(customerJpaRepository).findByIdWithPerson(id);
        verify(customerJpaRepository).save(existing);

        assertEquals("ID-NEW", existing.getPerson().getIdentification());
        assertEquals("New Name", existing.getPerson().getName());
        assertEquals("newHash", existing.getPasswordHash());
        assertFalse(existing.isStatus());
    }

    @Test
    void findByIdShouldReturnEmptyWhenNotFound() {
        UUID id = UUID.randomUUID();

        when(customerJpaRepository.findByIdWithPerson(id)).thenReturn(Optional.empty());

        StepVerifier.create(adapter.findById(id))
                .verifyComplete();

        verify(customerJpaRepository).findByIdWithPerson(id);
    }

    @Test
    void findByIdShouldReturnDomainWhenFound() {
        UUID id = UUID.randomUUID();

        CustomerEntity entity = validCustomerEntity(id, "ID-1");
        when(customerJpaRepository.findByIdWithPerson(id)).thenReturn(Optional.of(entity));

        StepVerifier.create(adapter.findById(id))
                .assertNext(found -> {
                    assertEquals(id, found.getId());
                    assertEquals("ID-1", found.getPerson().getIdentification());
                })
                .verifyComplete();

        verify(customerJpaRepository).findByIdWithPerson(id);
    }

    @Test
    void existsByIdentificationShouldDelegateToRepository() {
        when(customerJpaRepository.existsByPerson_Identification("ID-1")).thenReturn(true);

        StepVerifier.create(adapter.existsByIdentification("ID-1"))
                .expectNext(true)
                .verifyComplete();

        verify(customerJpaRepository).existsByPerson_Identification("ID-1");
    }

    @Test
    void findAllShouldMapPageContentAndTotalElements() {
        int page = 1;
        int size = 2;

        CustomerEntity e1 = validCustomerEntity(UUID.randomUUID(), "ID-1");
        CustomerEntity e2 = validCustomerEntity(UUID.randomUUID(), "ID-2");

        var pageable = PageRequest.of(page, size);
        var pageResult = new PageImpl<>(List.of(e1, e2), pageable, 10);

        when(customerJpaRepository.findAllWithPerson(any(PageRequest.class))).thenReturn(pageResult);

        StepVerifier.create(adapter.findAll(page, size))
                .assertNext(result -> {
                    assertNotNull(result);
                    assertEquals(page, result.page());
                    assertEquals(size, result.size());
                    assertEquals(10L, result.totalElements());
                    assertEquals(2, result.content().size());
                    assertEquals("ID-1", result.content().get(0).getPerson().getIdentification());
                    assertEquals("ID-2", result.content().get(1).getPerson().getIdentification());
                })
                .verifyComplete();

        ArgumentCaptor<PageRequest> captor = ArgumentCaptor.forClass(PageRequest.class);
        verify(customerJpaRepository).findAllWithPerson(captor.capture());
        assertEquals(page, captor.getValue().getPageNumber());
        assertEquals(size, captor.getValue().getPageSize());
    }

    @Test
    void deleteByIdShouldInvokeRepositoryAndComplete() {
        UUID id = UUID.randomUUID();
        doNothing().when(customerJpaRepository).deleteById(id);

        StepVerifier.create(adapter.deleteById(id))
                .verifyComplete();

        verify(customerJpaRepository).deleteById(id);
    }

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

    private CustomerEntity validCustomerEntity(UUID id, String identification) {
        PersonEntity person = new PersonEntity();
        person.setId(id);
        person.setName("Ana");
        person.setGender(Gender.FEMALE);
        person.setIdentification(identification);
        person.setAddress("Street 1");
        person.setPhone("555-000");

        CustomerEntity entity = new CustomerEntity();
        entity.setId(id);
        entity.setPerson(person);
        entity.setPasswordHash("hash");
        entity.setStatus(true);
        return entity;
    }
}
