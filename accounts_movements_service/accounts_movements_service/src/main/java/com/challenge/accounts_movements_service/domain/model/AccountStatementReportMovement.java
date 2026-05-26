package com.challenge.accounts_movements_service.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatementReportMovement {

    private UUID movementId;
    private LocalDate date;
    private MovementType type;
    private BigDecimal value;
    private BigDecimal balanceAfter;
}
