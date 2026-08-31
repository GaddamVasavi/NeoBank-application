package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EnterpriseAddonFeature
 */
public interface EnterpriseAddonFeatureService {

    List<EnterpriseAddonFeatureDto> getByTenant(UUID tenantId);

    List<EnterpriseAddonFeatureDto> getByUser(UUID userId);

    EnterpriseAddonFeatureDto create(EnterpriseAddonFeatureDto dto);

    EnterpriseAddonFeatureDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EnterpriseAddonFeatureDto> listAll();
}
