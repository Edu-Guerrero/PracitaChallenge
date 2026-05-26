package com.challenge.accounts_movements_service.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movement {

    private UUID id;
    private UUID accountId;
    private LocalDate date;
    private MovementType type;
    private BigDecimal value;

    private BigDecimal balanceAfter;
}
