package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface AccountTierService {
    List<AccountTierDto> getByAccount(UUID accountId);
    AccountTierDto create(AccountTierDto dto);
    AccountTierDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
