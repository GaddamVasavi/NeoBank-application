package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FraudRuleConfigMaster
 */
public interface FraudRuleConfigMasterService {

    List<FraudRuleConfigMasterDto> getByTenant(UUID tenantId);

    List<FraudRuleConfigMasterDto> getByUser(UUID userId);

    FraudRuleConfigMasterDto create(FraudRuleConfigMasterDto dto);

    FraudRuleConfigMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FraudRuleConfigMasterDto> listAll();
}
