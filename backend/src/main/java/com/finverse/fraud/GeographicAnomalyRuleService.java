package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for GeographicAnomalyRule
 */
public interface GeographicAnomalyRuleService {

    List<GeographicAnomalyRuleDto> getByTenant(UUID tenantId);

    List<GeographicAnomalyRuleDto> getByUser(UUID userId);

    GeographicAnomalyRuleDto create(GeographicAnomalyRuleDto dto);

    GeographicAnomalyRuleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<GeographicAnomalyRuleDto> listAll();
}
