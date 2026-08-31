package com.finverse.beneficiaries;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TrustedBeneficiaryProfile
 */
public interface TrustedBeneficiaryProfileService {

    List<TrustedBeneficiaryProfileDto> getByTenant(UUID tenantId);

    List<TrustedBeneficiaryProfileDto> getByUser(UUID userId);

    TrustedBeneficiaryProfileDto create(TrustedBeneficiaryProfileDto dto);

    TrustedBeneficiaryProfileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TrustedBeneficiaryProfileDto> listAll();
}
