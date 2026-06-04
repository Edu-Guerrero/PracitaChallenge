package com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.domain.model.MovementType;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.MovementEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MovementJpaMapperTest {

    private MovementJpaMapper movementJpaMapper;

    @BeforeEach
    void setUp() {
        movementJpaMapper = Mappers.getMapper(MovementJpaMapper.class);
    }

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

        MovementEntity entity = movementJpaMapper.toEntity(domain);
        assertNotNull(entity);
        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getAccountId(), entity.getAccountId());
        assertEquals(domain.getDate(), entity.getDate());
        assertEquals(domain.getType(), entity.getType());
        assertEquals(domain.getValue(), entity.getValue());
        assertEquals(domain.getBalanceAfter(), entity.getBalanceAfter());

        Movement mappedBack = movementJpaMapper.toDomain(entity);
        assertNotNull(mappedBack);
        assertEquals(entity.getId(), mappedBack.getId());
        assertEquals(entity.getAccountId(), mappedBack.getAccountId());
        assertEquals(entity.getDate(), mappedBack.getDate());
    }

    @Test
    void shouldReturnNullWhenInputIsNull() {
        assertNull(movementJpaMapper.toEntity(null));
        assertNull(movementJpaMapper.toDomain(null));
    }
}
