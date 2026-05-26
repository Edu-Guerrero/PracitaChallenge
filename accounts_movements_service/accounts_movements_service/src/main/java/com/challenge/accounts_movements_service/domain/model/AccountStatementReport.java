package com.challenge.accounts_movements_service.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatementReport {

    private UUID clientId;
    private LocalDate startDate;
    private LocalDate endDate;

    @Singular
    private List<AccountStatementReportAccount> accounts;
}
