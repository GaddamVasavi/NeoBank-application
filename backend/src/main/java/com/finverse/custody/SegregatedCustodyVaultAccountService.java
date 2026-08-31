package com.finverse.custody;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SegregatedCustodyVaultAccount
 */
public interface SegregatedCustodyVaultAccountService {

    List<SegregatedCustodyVaultAccountDto> getByTenant(UUID tenantId);

    List<SegregatedCustodyVaultAccountDto> getByUser(UUID userId);

    SegregatedCustodyVaultAccountDto create(SegregatedCustodyVaultAccountDto dto);

    SegregatedCustodyVaultAccountDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SegregatedCustodyVaultAccountDto> listAll();
}
