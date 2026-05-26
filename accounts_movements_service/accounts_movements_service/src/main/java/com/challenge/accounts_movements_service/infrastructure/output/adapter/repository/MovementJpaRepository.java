package com.challenge.accounts_movements_service.infrastructure.output.adapter.repository;

import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.MovementEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementJpaRepository extends JpaRepository<MovementEntity, UUID> {

    Page<MovementEntity> findAllByAccountId(UUID accountId, Pageable pageable);

    Page<MovementEntity> findAllByAccountIdAndDateBetween(UUID accountId, LocalDate startDate, LocalDate endDate, Pageable pageable);

    List<MovementEntity> findAllByAccountIdAndDateBetween(UUID accountId, LocalDate startDate, LocalDate endDate);
}