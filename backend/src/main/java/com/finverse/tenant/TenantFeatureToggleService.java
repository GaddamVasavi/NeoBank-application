package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantFeatureToggle
 */
public interface TenantFeatureToggleService {

    List<TenantFeatureToggleDto> getByTenant(UUID tenantId);

    List<TenantFeatureToggleDto> getByUser(UUID userId);

    TenantFeatureToggleDto create(TenantFeatureToggleDto dto);

    TenantFeatureToggleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantFeatureToggleDto> listAll();
}
