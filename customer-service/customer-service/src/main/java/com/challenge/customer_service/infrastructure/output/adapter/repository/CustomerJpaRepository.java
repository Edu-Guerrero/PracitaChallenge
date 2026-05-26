package com.challenge.customer_service.infrastructure.output.adapter.repository;

import com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntity;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {

    boolean existsByPerson_Identification(String identification);

    @Query("""
           select c
           from CustomerEntity c
           join fetch c.person p
           where c.id = :id
           """)
    Optional<CustomerEntity> findByIdWithPerson(@Param("id") UUID id);

    @Query(
            value = """
                select c
                from CustomerEntity c
                join fetch c.person p
                """,
            countQuery = """
                     select count(c)
                     from CustomerEntity c
                     """
    )
    Page<CustomerEntity> findAllWithPerson(Pageable pageable);

    Page<CustomerEntity> findAll(Pageable pageable);
}