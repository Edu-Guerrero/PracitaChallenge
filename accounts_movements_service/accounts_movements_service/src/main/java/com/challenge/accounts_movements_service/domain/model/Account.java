package com.challenge.accounts_movements_service.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private UUID id;
    private UUID customerId;
    private String accountNumber;
    private AccountType type;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
    private boolean status;
}
