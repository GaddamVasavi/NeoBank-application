package com.finverse.audit;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TamperEvidentLogVerifier
 */
public interface TamperEvidentLogVerifierService {

    List<TamperEvidentLogVerifierDto> getByTenant(UUID tenantId);

    List<TamperEvidentLogVerifierDto> getByUser(UUID userId);

    TamperEvidentLogVerifierDto create(TamperEvidentLogVerifierDto dto);

    TamperEvidentLogVerifierDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TamperEvidentLogVerifierDto> listAll();
}
