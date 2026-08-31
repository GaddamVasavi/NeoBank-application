package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantProfileMaster
 */
public interface TenantProfileMasterService {

    List<TenantProfileMasterDto> getByTenant(UUID tenantId);

    List<TenantProfileMasterDto> getByUser(UUID userId);

    TenantProfileMasterDto create(TenantProfileMasterDto dto);

    TenantProfileMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantProfileMasterDto> listAll();
}
