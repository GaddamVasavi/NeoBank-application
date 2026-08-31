package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BeneficialOwnershipDeclaration
 */
public interface BeneficialOwnershipDeclarationService {

    List<BeneficialOwnershipDeclarationDto> getByTenant(UUID tenantId);

    List<BeneficialOwnershipDeclarationDto> getByUser(UUID userId);

    BeneficialOwnershipDeclarationDto create(BeneficialOwnershipDeclarationDto dto);

    BeneficialOwnershipDeclarationDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BeneficialOwnershipDeclarationDto> listAll();
}
