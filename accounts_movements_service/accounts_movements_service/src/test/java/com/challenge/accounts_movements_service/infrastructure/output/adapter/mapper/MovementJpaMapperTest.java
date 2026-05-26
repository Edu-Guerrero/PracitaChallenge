package com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.domain.model.MovementType;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.MovementEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MovementJpaMapperTest {

    @Test
    void shouldMapDomainToEntityAndBack() {
        Movement domain = Movement.builder()
                .id(UUID.randomUUID())
                .accountId(UUID.randomUUID())
                .date(LocalDate.of(2023, 1, 1))
                .type(MovementType.CREDIT)
                .value(BigDecimal.valueOf(10.5))
                .balanceAfter(BigDecimal.valueOf(20.5))
                .build();

        MovementEntity entity = MovementJpaMapper.toEntity(domain);
        assertNotNull(entity);
        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getAccountId(), entity.getAccountId());
        assertEquals(domain.getDate(), entity.getDate());
        assertEquals(domain.getType(), entity.getType());
        assertEquals(domain.getValue(), entity.getValue());
        assertEquals(domain.getBalanceAfter(), entity.getBalanceAfter());

        Movement mappedBack = MovementJpaMapper.toDomain(entity);
        assertNotNull(mappedBack);
        assertEquals(entity.getId(), mappedBack.getId());
        assertEquals(entity.getAccountId(), mappedBack.getAccountId());
        assertEquals(entity.getDate(), mappedBack.getDate());
    }

    @Test
    void shouldReturnNullWhenInputIsNull() {
        assertNull(MovementJpaMapper.toEntity(null));
        assertNull(MovementJpaMapper.toDomain(null));
    }
}
