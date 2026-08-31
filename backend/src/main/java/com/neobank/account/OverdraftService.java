package com.neobank.account;
import java.math.BigDecimal; import java.util.UUID;
public interface OverdraftService {
    boolean hasSufficientCover(Account primaryAccount, BigDecimal requiredAmount);
    void sweepCover(Account primaryAccount, Account backupAccount, BigDecimal requiredAmount);
}
