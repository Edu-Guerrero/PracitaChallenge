package com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.MovementEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementJpaMapper {

    MovementEntity toEntity(Movement movement);

    Movement toDomain(MovementEntity entity);
}
