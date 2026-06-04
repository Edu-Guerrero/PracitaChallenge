package com.challenge.customer_service.infrastructure.input.adapter.mapper;

import com.challenge.customer_service.application.util.PagedResult;
import com.challenge.customer_service.domain.model.Customer;
import com.challenge.customer_service.domain.model.Gender;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.CreateCustomerRequest;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.CustomerResponse;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.PagedCustomersResponse;
import com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateCustomerRequest;
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
public interface CustomerRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person.name", source = "name")
    @Mapping(target = "person.gender", source = "gender")
    @Mapping(target = "person.identification", source = "identification")
    @Mapping(target = "person.address", source = "address")
    @Mapping(target = "person.phone", source = "phone")
    @Mapping(target = "passwordHash", source = "password")
    @Mapping(target = "status", expression = "java(Boolean.TRUE.equals(dto.getStatus()))")
    Customer toDomain(CreateCustomerRequest dto);

    @Mapping(target = "id", source = "customerId")
    @Mapping(target = "person.name", source = "dto.name")
    @Mapping(target = "person.gender", source = "dto.gender")
    @Mapping(target = "person.identification", source = "dto.identification")
    @Mapping(target = "person.address", source = "dto.address")
    @Mapping(target = "person.phone", source = "dto.phone")
    @Mapping(target = "passwordHash", source = "dto.password")
    @Mapping(target = "status", expression = "java(Boolean.TRUE.equals(dto.getStatus()))")
    Customer toDomain(UUID customerId, UpdateCustomerRequest dto);

    @Mapping(target = "name", source = "person.name")
    @Mapping(target = "gender", source = "person.gender")
    @Mapping(target = "identification", source = "person.identification")
    @Mapping(target = "address", source = "person.address")
    @Mapping(target = "phone", source = "person.phone")
    @Mapping(target = "status", source = "status")
    CustomerResponse toResponse(Customer customer);

    @Mapping(target = "content", source = "content")
    @Mapping(target = "totalElements", expression = "java((int) page.totalElements())")
    PagedCustomersResponse toPagedResponse(PagedResult<Customer> page);

    default Gender map(com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.Gender apiGender) {
        if (apiGender == null) return null;
        return switch (apiGender) {
            case MALE -> Gender.MALE;
            case FEMALE -> Gender.FEMALE;
            case OTHER -> Gender.OTHER;
        };
    }

    default com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.Gender map(Gender domainGender) {
        if (domainGender == null) return null;
        return switch (domainGender) {
            case MALE -> com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.Gender.MALE;
            case FEMALE -> com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.Gender.FEMALE;
            case OTHER -> com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean.Gender.OTHER;
        };
    }
}
