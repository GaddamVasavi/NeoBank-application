package com.neobank.transaction;
import com.neobank.account.Account; import java.math.BigDecimal; import java.util.UUID;
public interface LedgerService {
    void postDoubleEntry(String ref, Account debitAccount, Account creditAccount, BigDecimal amount, String narration);
}
