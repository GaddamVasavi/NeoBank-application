package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DeviceTakeoverDetectionRule
 */
public interface DeviceTakeoverDetectionRuleService {

    List<DeviceTakeoverDetectionRuleDto> getByTenant(UUID tenantId);

    List<DeviceTakeoverDetectionRuleDto> getByUser(UUID userId);

    DeviceTakeoverDetectionRuleDto create(DeviceTakeoverDetectionRuleDto dto);

    DeviceTakeoverDetectionRuleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DeviceTakeoverDetectionRuleDto> listAll();
}
