package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CheckingAccountMaster
 */
public interface CheckingAccountMasterService {

    List<CheckingAccountMasterDto> getByTenant(UUID tenantId);

    List<CheckingAccountMasterDto> getByUser(UUID userId);

    CheckingAccountMasterDto create(CheckingAccountMasterDto dto);

    CheckingAccountMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CheckingAccountMasterDto> listAll();
}
