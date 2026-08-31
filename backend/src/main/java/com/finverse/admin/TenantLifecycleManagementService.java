package com.finverse.admin;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantLifecycleManagement
 */
public interface TenantLifecycleManagementService {

    List<TenantLifecycleManagementDto> getByTenant(UUID tenantId);

    List<TenantLifecycleManagementDto> getByUser(UUID userId);

    TenantLifecycleManagementDto create(TenantLifecycleManagementDto dto);

    TenantLifecycleManagementDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantLifecycleManagementDto> listAll();
}
