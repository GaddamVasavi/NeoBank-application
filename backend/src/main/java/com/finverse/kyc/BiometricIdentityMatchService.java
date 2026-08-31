package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BiometricIdentityMatch
 */
public interface BiometricIdentityMatchService {

    List<BiometricIdentityMatchDto> getByTenant(UUID tenantId);

    List<BiometricIdentityMatchDto> getByUser(UUID userId);

    BiometricIdentityMatchDto create(BiometricIdentityMatchDto dto);

    BiometricIdentityMatchDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BiometricIdentityMatchDto> listAll();
}
