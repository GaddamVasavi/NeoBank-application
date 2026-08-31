package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AccountInterestAccrualLog
 */
public interface AccountInterestAccrualLogService {

    List<AccountInterestAccrualLogDto> getByTenant(UUID tenantId);

    List<AccountInterestAccrualLogDto> getByUser(UUID userId);

    AccountInterestAccrualLogDto create(AccountInterestAccrualLogDto dto);

    AccountInterestAccrualLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AccountInterestAccrualLogDto> listAll();
}
