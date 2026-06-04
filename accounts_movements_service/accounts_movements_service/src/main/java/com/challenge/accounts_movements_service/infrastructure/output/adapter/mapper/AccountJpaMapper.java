package com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper;

import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.infrastructure.output.adapter.entity.AccountEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AccountJpaMapper {

    AccountEntity toEntity(Account account);

    Account toDomain(AccountEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDomain(Account account, @MappingTarget AccountEntity entity);
}
