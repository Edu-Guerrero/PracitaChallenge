package com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.AccountType;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.AccountEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountJpaMapperTest {

    @Test
    void shouldMapDomainToEntityAndBack() {
        Account domain = Account.builder()
                .id(UUID.randomUUID())
                .customerId(UUID.randomUUID())
                .accountNumber("999888")
                .type(AccountType.SAVINGS)
                .initialBalance(BigDecimal.ONE)
                .currentBalance(BigDecimal.TEN)
                .status(true)
                .build();

        AccountEntity entity = AccountJpaMapper.toEntity(domain);
        assertNotNull(entity);
        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getCustomerId(), entity.getCustomerId());
        assertEquals(domain.getAccountNumber(), entity.getAccountNumber());
        assertEquals(domain.getType(), entity.getType());
        assertEquals(domain.getInitialBalance(), entity.getInitialBalance());
        assertTrue(entity.isStatus());

        Account mappedBack = AccountJpaMapper.toDomain(entity);
        assertNotNull(mappedBack);
        assertEquals(entity.getId(), mappedBack.getId());
        assertEquals(entity.getAccountNumber(), mappedBack.getAccountNumber());
        assertEquals(entity.getType(), mappedBack.getType());
    }

    @Test
    void shouldReturnNullWhenInputIsNull() {
        assertNull(AccountJpaMapper.toEntity(null));
        assertNull(AccountJpaMapper.toDomain(null));
    }

    @Test
    void applyToExistingEntityShouldCopyFields() {
        Account source = Account.builder()
                .customerId(UUID.randomUUID())
                .accountNumber("ACC100")
                .type(AccountType.CHECKING)
                .initialBalance(BigDecimal.TEN)
                .currentBalance(BigDecimal.TEN)
                .status(false)
                .build();

        AccountEntity target = AccountEntity.builder().build();
        AccountJpaMapper.applyToExistingEntity(source, target);

        assertEquals(source.getCustomerId(), target.getCustomerId());
        assertEquals(source.getAccountNumber(), target.getAccountNumber());
        assertEquals(source.getType(), target.getType());
        assertEquals(source.getInitialBalance(), target.getInitialBalance());
        assertEquals(source.getCurrentBalance(), target.getCurrentBalance());
        assertFalse(target.isStatus());
    }
}
