package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantCustomBranding
 */
public interface TenantCustomBrandingService {

    List<TenantCustomBrandingDto> getByTenant(UUID tenantId);

    List<TenantCustomBrandingDto> getByUser(UUID userId);

    TenantCustomBrandingDto create(TenantCustomBrandingDto dto);

    TenantCustomBrandingDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantCustomBrandingDto> listAll();
}
