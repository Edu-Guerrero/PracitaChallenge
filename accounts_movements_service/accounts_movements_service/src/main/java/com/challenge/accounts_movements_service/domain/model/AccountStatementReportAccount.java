package com.challenge.accounts_movements_service.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatementReportAccount {

    private UUID accountId;
    private String accountNumber;
    private AccountType type;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;

    @Singular
    private List<AccountStatementReportMovement> movements;
}
