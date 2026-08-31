package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for HighYieldSavingsAccount
 */
public interface HighYieldSavingsAccountService {

    List<HighYieldSavingsAccountDto> getByTenant(UUID tenantId);

    List<HighYieldSavingsAccountDto> getByUser(UUID userId);

    HighYieldSavingsAccountDto create(HighYieldSavingsAccountDto dto);

    HighYieldSavingsAccountDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<HighYieldSavingsAccountDto> listAll();
}
