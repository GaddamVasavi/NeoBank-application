package com.neobank.account;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
public interface AccountHoldService {
    AccountHold placeHold(UUID accountId, BigDecimal amount, String reason, String ref);
    void releaseHold(UUID holdId);
    List<AccountHold> getActiveHolds(UUID accountId);
}
