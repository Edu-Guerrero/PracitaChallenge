package com.challenge.accounts_movements_service.infrastructure.output.adapter.repository;

import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.AccountEntity;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {

    boolean existsByAccountNumber(String accountNumber);

    Page<AccountEntity> findAllByCustomerId(UUID customerId, Pageable pageable);
}
