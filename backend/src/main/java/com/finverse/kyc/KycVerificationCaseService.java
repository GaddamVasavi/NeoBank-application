package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for KycVerificationCase
 */
public interface KycVerificationCaseService {

    List<KycVerificationCaseDto> getByTenant(UUID tenantId);

    List<KycVerificationCaseDto> getByUser(UUID userId);

    KycVerificationCaseDto create(KycVerificationCaseDto dto);

    KycVerificationCaseDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<KycVerificationCaseDto> listAll();
}
