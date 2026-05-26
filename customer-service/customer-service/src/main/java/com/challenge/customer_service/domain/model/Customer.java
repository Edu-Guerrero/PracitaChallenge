package com.challenge.customer_service.domain.model;

import java.util.UUID;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer{

    private UUID id;
    private Person person;
    private String passwordHash;
    private boolean status;
}