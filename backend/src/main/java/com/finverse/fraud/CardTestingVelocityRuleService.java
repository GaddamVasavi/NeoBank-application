package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardTestingVelocityRule
 */
public interface CardTestingVelocityRuleService {

    List<CardTestingVelocityRuleDto> getByTenant(UUID tenantId);

    List<CardTestingVelocityRuleDto> getByUser(UUID userId);

    CardTestingVelocityRuleDto create(CardTestingVelocityRuleDto dto);

    CardTestingVelocityRuleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardTestingVelocityRuleDto> listAll();
}
