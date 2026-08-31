package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AccountStatementArchive
 */
public interface AccountStatementArchiveService {

    List<AccountStatementArchiveDto> getByTenant(UUID tenantId);

    List<AccountStatementArchiveDto> getByUser(UUID userId);

    AccountStatementArchiveDto create(AccountStatementArchiveDto dto);

    AccountStatementArchiveDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AccountStatementArchiveDto> listAll();
}
