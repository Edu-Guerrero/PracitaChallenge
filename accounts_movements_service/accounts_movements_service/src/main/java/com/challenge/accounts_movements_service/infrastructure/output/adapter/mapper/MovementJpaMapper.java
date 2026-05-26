package com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.MovementEntity;

public class MovementJpaMapper {

    private MovementJpaMapper() {}

    public static MovementEntity toEntity(Movement d) {
        if (d == null) return null;

        return MovementEntity.builder()
                .id(d.getId())
                .accountId(d.getAccountId())
                .date(d.getDate())
                .type(d.getType())
                .value(d.getValue())
                .balanceAfter(d.getBalanceAfter())
                .build();
    }

    public static Movement toDomain(MovementEntity e) {
        if (e == null) return null;

        return Movement.builder()
                .id(e.getId())
                .accountId(e.getAccountId())
                .date(e.getDate())
                .type(e.getType())
                .value(e.getValue())
                .balanceAfter(e.getBalanceAfter())
                .build();
    }
}