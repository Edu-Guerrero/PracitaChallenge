package com.challenge.accounts_movements_service.domain.policy;

import com.challenge.accounts_movements_service.domain.exception.AccountInactiveException;
import com.challenge.accounts_movements_service.domain.exception.DomainValidationException;
import com.challenge.accounts_movements_service.domain.exception.InsufficientFundsException;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.MovementType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MovementPolicyTest {

    private MovementPolicy policy;

    @BeforeEach
    void setUp() {
        policy = new MovementPolicy();
    }

    private Account createAccount(boolean active, BigDecimal balance) {
        Account account = new Account();
        account.setId(UUID.randomUUID());
        account.setStatus(active);
        account.setCurrentBalance(balance);
        return account;
    }

    @Test
    void calculateNewBalance_shouldAddValueOnCredit() {
        Account acc = createAccount(true, BigDecimal.valueOf(100));
        BigDecimal newBalance = policy.calculateNewBalance(acc, MovementType.CREDIT, BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(150), newBalance);
    }

    @Test
    void calculateNewBalance_shouldSubtractValueOnDebit() {
        Account acc = createAccount(true, BigDecimal.valueOf(200));
        BigDecimal newBalance = policy.calculateNewBalance(acc, MovementType.DEBIT, BigDecimal.valueOf(75));
        assertEquals(BigDecimal.valueOf(125), newBalance);
    }

    @Test
    void calculateNewBalance_shouldThrowIfDebitMakesNegative() {
        Account acc = createAccount(true, BigDecimal.valueOf(40));
        assertThrows(InsufficientFundsException.class, () ->
                policy.calculateNewBalance(acc, MovementType.DEBIT, BigDecimal.valueOf(100))
        );
    }

    @Test
    void calculateNewBalance_shouldInitializeNullBalanceAsZero() {
        Account acc = createAccount(true, null);
        BigDecimal newBalance = policy.calculateNewBalance(acc, MovementType.CREDIT, BigDecimal.valueOf(60));
        assertEquals(BigDecimal.valueOf(60), newBalance);
    }

    @Test
    void calculateNewBalance_shouldThrowIfAccountInactive() {
        Account acc = createAccount(false, BigDecimal.valueOf(50));
        assertThrows(AccountInactiveException.class, () ->
                policy.calculateNewBalance(acc, MovementType.CREDIT, BigDecimal.valueOf(10))
        );
    }

    @Test
    void calculateNewBalance_shouldThrowIfValueNegativeOrZero() {
        Account acc = createAccount(true, BigDecimal.valueOf(200));
        assertThrows(DomainValidationException.class, () ->
                policy.calculateNewBalance(acc, MovementType.CREDIT, BigDecimal.valueOf(0))
        );
        assertThrows(DomainValidationException.class, () ->
                policy.calculateNewBalance(acc, MovementType.DEBIT, BigDecimal.valueOf(-1))
        );
    }

    @Test
    void calculateNewBalance_shouldThrowIfValueIsNull() {
        Account acc = createAccount(true, BigDecimal.valueOf(100));
        assertThrows(DomainValidationException.class, () ->
                policy.calculateNewBalance(acc, MovementType.CREDIT, null)
        );
    }

    @Test
    void calculateNewBalance_shouldThrowIfAccountIsNull() {
        assertThrows(NullPointerException.class, () ->
                policy.calculateNewBalance(null, MovementType.CREDIT, BigDecimal.ONE)
        );
    }

    @Test
    void calculateNewBalance_shouldThrowIfMovementTypeIsNull() {
        Account acc = createAccount(true, BigDecimal.TEN);
        assertThrows(NullPointerException.class, () ->
                policy.calculateNewBalance(acc, null, BigDecimal.TEN)
        );
    }
}
