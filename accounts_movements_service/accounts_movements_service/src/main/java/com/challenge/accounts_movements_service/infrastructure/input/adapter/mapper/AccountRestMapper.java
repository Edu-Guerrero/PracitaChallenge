package com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper;

import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.AccountType;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.CreateAccountRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.PagedAccountsResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface AccountRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", source = "type")
    @Mapping(target = "status", expression = "java(Boolean.TRUE.equals(dto.getStatus()))")
    @Mapping(target = "currentBalance", source = "initialBalance")
    Account toDomain(CreateAccountRequest dto);

    @Mapping(target = "id", source = "accountId")
    @Mapping(target = "type", source = "dto.type")
    @Mapping(target = "status", expression = "java(Boolean.TRUE.equals(dto.getStatus()))")
    @Mapping(target = "currentBalance", ignore = true)
    Account toDomain(UUID accountId, UpdateAccountRequest dto);

    @Mapping(target = "type", source = "type")
    AccountResponse toResponse(Account domain);

    @Mapping(target = "content", source = "content")
    @Mapping(target = "page", source = "page")
    @Mapping(target = "size", source = "size")
    @Mapping(target = "totalElements", expression = "java((int) page.totalElements())")
    PagedAccountsResponse toPagedResponse(PagedResult<Account> page);

    default AccountType map(com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountType apiType) {
        if (apiType == null) return null;
        return switch (apiType) {
            case SAVINGS -> AccountType.SAVINGS;
            case CHECKING -> AccountType.CHECKING;
        };
    }

    default com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountType map(AccountType domainType) {
        if (domainType == null) return null;
        return switch (domainType) {
            case SAVINGS -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountType.SAVINGS;
            case CHECKING -> com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.AccountType.CHECKING;
        };
    }

    default java.math.BigDecimal map(Double value) {
        return value == null ? null : java.math.BigDecimal.valueOf(value);
    }

}