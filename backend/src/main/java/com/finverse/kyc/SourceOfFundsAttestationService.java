package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SourceOfFundsAttestation
 */
public interface SourceOfFundsAttestationService {

    List<SourceOfFundsAttestationDto> getByTenant(UUID tenantId);

    List<SourceOfFundsAttestationDto> getByUser(UUID userId);

    SourceOfFundsAttestationDto create(SourceOfFundsAttestationDto dto);

    SourceOfFundsAttestationDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SourceOfFundsAttestationDto> listAll();
}
