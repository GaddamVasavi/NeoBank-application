package com.neobank.account;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
public interface AccountService {
    List<AccountDto> getUserAccounts(UUID userId);
    AccountDto getAccountById(UUID accountId, UUID userId);
    AccountDto createAccount(UUID userId, CreateAccountRequest request);
    AccountDto updateAccountStatus(UUID accountId, UUID userId, AccountStatus status);
    AccountDto updateLimits(UUID accountId, UUID userId, BigDecimal dailyLimit, BigDecimal singleLimit);
}
