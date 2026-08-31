package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for HighRiskJurisdictionFilter
 */
public interface HighRiskJurisdictionFilterService {

    List<HighRiskJurisdictionFilterDto> getByTenant(UUID tenantId);

    List<HighRiskJurisdictionFilterDto> getByUser(UUID userId);

    HighRiskJurisdictionFilterDto create(HighRiskJurisdictionFilterDto dto);

    HighRiskJurisdictionFilterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<HighRiskJurisdictionFilterDto> listAll();
}
