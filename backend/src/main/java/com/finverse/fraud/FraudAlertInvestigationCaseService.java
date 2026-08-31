package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FraudAlertInvestigationCase
 */
public interface FraudAlertInvestigationCaseService {

    List<FraudAlertInvestigationCaseDto> getByTenant(UUID tenantId);

    List<FraudAlertInvestigationCaseDto> getByUser(UUID userId);

    FraudAlertInvestigationCaseDto create(FraudAlertInvestigationCaseDto dto);

    FraudAlertInvestigationCaseDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FraudAlertInvestigationCaseDto> listAll();
}
