package com.challenge.customer_service.infrastructure.output.adapter.repository;

import com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, UUID> {
}
