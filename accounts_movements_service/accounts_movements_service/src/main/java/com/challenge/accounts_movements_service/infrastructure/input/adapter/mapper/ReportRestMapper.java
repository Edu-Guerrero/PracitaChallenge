package com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.AccountStatementReport;
import com.challenge.accounts_movements_service.domain.model.AccountStatementReportAccount;
import com.challenge.accounts_movements_service.domain.model.AccountStatementReportMovement;
import com.challenge.accounts_movements_service.domain.model.AccountType;
import com.challenge.accounts_movements_service.domain.model.MovementType;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountStatementAccount;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ReportRestMapper {

    @Mapping(target = "clientId", source = "clientId")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "accounts", source = "accounts")
    com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountStatementReport
    toResponse(AccountStatementReport domain);

    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "accountNumber", source = "accountNumber")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "initialBalance", source = "initialBalance")
    @Mapping(target = "currentBalance", source = "currentBalance")
    @Mapping(target = "movements", expression = "java(toMovementResponses(domain.getAccountId(), domain.getMovements()))")
    AccountStatementAccount toResponse(AccountStatementReportAccount domain);


    default List<MovementResponse> toMovementResponses(UUID accountId, List<AccountStatementReportMovement> movements) {
        if (movements == null) return List.of();
        return movements.stream()
                .map(m -> toResponse(accountId, m))
                .toList();
    }

    @Mapping(target = "id", source = "movement.movementId")
    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "date", source = "movement.date")
    @Mapping(target = "type", source = "movement.type")
    @Mapping(target = "value", source = "movement.value")
    @Mapping(target = "balanceAfter", source = "movement.balanceAfter")
    MovementResponse toResponse(UUID accountId, AccountStatementReportMovement movement);

    default com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountType map(AccountType domainType) {
        if (domainType == null) return null;
        return switch (domainType) {
            case SAVINGS -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountType.SAVINGS;
            case CHECKING -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountType.CHECKING;
        };
    }

    default com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementType map(MovementType domainType) {
        if (domainType == null) return null;
        return switch (domainType) {
            case DEBIT -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementType.DEBIT;
            case CREDIT -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementType.CREDIT;
        };
    }

    default Double map(java.math.BigDecimal value) {
        return value == null ? null : value.doubleValue();
    }
}
