package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ChargebackFraudEvidence
 */
public interface ChargebackFraudEvidenceService {

    List<ChargebackFraudEvidenceDto> getByTenant(UUID tenantId);

    List<ChargebackFraudEvidenceDto> getByUser(UUID userId);

    ChargebackFraudEvidenceDto create(ChargebackFraudEvidenceDto dto);

    ChargebackFraudEvidenceDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ChargebackFraudEvidenceDto> listAll();
}
