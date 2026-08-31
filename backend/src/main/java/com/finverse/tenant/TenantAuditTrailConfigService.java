package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantAuditTrailConfig
 */
public interface TenantAuditTrailConfigService {

    List<TenantAuditTrailConfigDto> getByTenant(UUID tenantId);

    List<TenantAuditTrailConfigDto> getByUser(UUID userId);

    TenantAuditTrailConfigDto create(TenantAuditTrailConfigDto dto);

    TenantAuditTrailConfigDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantAuditTrailConfigDto> listAll();
}
