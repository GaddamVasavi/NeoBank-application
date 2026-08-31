package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AccountFreezeOrderFile
 */
public interface AccountFreezeOrderFileService {

    List<AccountFreezeOrderFileDto> getByTenant(UUID tenantId);

    List<AccountFreezeOrderFileDto> getByUser(UUID userId);

    AccountFreezeOrderFileDto create(AccountFreezeOrderFileDto dto);

    AccountFreezeOrderFileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AccountFreezeOrderFileDto> listAll();
}
