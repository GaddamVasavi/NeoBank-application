package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PepSanctionsScreeningRecord
 */
public interface PepSanctionsScreeningRecordService {

    List<PepSanctionsScreeningRecordDto> getByTenant(UUID tenantId);

    List<PepSanctionsScreeningRecordDto> getByUser(UUID userId);

    PepSanctionsScreeningRecordDto create(PepSanctionsScreeningRecordDto dto);

    PepSanctionsScreeningRecordDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PepSanctionsScreeningRecordDto> listAll();
}
