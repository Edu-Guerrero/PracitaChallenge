package com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper;

import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.domain.model.MovementType;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.CreateMovementRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.PagedMovementsResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateMovementRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MovementRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "type", source = "type") // uses map(api MovementType)
    @Mapping(target = "value", source = "value")
    // balanceAfter is calculated by MovementService (business rule)
    @Mapping(target = "balanceAfter", ignore = true)
    Movement toDomain(CreateMovementRequest dto);

    @Mapping(target = "id", source = "movementId")
    @Mapping(target = "accountId", source = "dto.accountId")
    @Mapping(target = "date", source = "dto.date")
    @Mapping(target = "type", source = "dto.type") // uses map(...)
    @Mapping(target = "value", source = "dto.value")
    @Mapping(target = "balanceAfter", ignore = true)
    Movement toDomain(UUID movementId, UpdateMovementRequest dto);

    @Mapping(target = "type", source = "type") // uses map(domain MovementType)
    MovementResponse toResponse(Movement domain);

    @Mapping(target = "content", source = "content")
    @Mapping(target = "page", source = "page")
    @Mapping(target = "size", source = "size")
    @Mapping(target = "totalElements", expression = "java((int) page.totalElements())")
    PagedMovementsResponse toPagedResponse(PagedResult<Movement> page);

    default MovementType map(com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementType apiType) {
        if (apiType == null) return null;
        return switch (apiType) {
            case DEBIT -> MovementType.DEBIT;
            case CREDIT -> MovementType.CREDIT;
        };
    }

    default com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementType map(MovementType domainType) {
        if (domainType == null) return null;
        return switch (domainType) {
            case DEBIT -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementType.DEBIT;
            case CREDIT -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementType.CREDIT;
        };
    }
}
