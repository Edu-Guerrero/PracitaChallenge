package com.challenge.accounts_movements_service.domain.policy;

import com.challenge.accounts_movements_service.domain.exception.AccountInactiveException;
import com.challenge.accounts_movements_service.domain.exception.DomainValidationException;
import com.challenge.accounts_movements_service.domain.exception.InsufficientFundsException;
import com.challenge.accounts_movements_service.domain.model.Account;
import com.challenge.accounts_movements_service.domain.model.MovementType;

import java.math.BigDecimal;
import java.util.Objects;

public class MovementPolicy {

    public BigDecimal calculateNewBalance(Account account, MovementType type, BigDecimal value) {
        Objects.requireNonNull(account, "account is required");
        Objects.requireNonNull(type, "movement type is required");
        requirePositive(value);

        if (!account.isStatus()) {
            throw new AccountInactiveException("Account is inactive");
        }

        BigDecimal current = defaultZero(account.getCurrentBalance());

        return switch (type) {
            case CREDIT -> current.add(value);
            case DEBIT -> {
                BigDecimal newBalance = current.subtract(value);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                    throw new InsufficientFundsException("Saldo no disponible");
                }
                yield newBalance;
            }
        };
    }

    private static void requirePositive(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new DomainValidationException("movement value must be > 0");
        }
    }

    private static BigDecimal defaultZero(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }
}
