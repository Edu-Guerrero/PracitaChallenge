package com.challenge.accounts_movements_service.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountStatementReportTest {

    @Test
    void shouldBuildReportWithAccountsList() {
        UUID clientId = UUID.randomUUID();
        LocalDate begin = LocalDate.of(2023, 1, 1);
        LocalDate end = LocalDate.of(2023, 12, 31);

        AccountStatementReportAccount acc1 = AccountStatementReportAccount.builder()
                .accountId(UUID.randomUUID())
                .accountNumber("ACC001")
                .type(AccountType.SAVINGS)
                .build();

        AccountStatementReport report = AccountStatementReport.builder()
                .clientId(clientId)
                .startDate(begin)
                .endDate(end)
                .account(acc1)
                .build();

        assertEquals(clientId, report.getClientId());
        assertEquals(begin, report.getStartDate());
        assertEquals(end, report.getEndDate());
        assertEquals(1, report.getAccounts().size());
        assertEquals(acc1, report.getAccounts().get(0));
    }

    @Test
    void shouldSetFieldsViaAllArgsConstructor() {
        UUID clientId = UUID.randomUUID();
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now();
        List<AccountStatementReportAccount> accs = List.of();

        AccountStatementReport report = new AccountStatementReport(clientId, start, end, accs);
        assertEquals(clientId, report.getClientId());
        assertEquals(start, report.getStartDate());
        assertEquals(end, report.getEndDate());
        assertEquals(accs, report.getAccounts());
    }
}
