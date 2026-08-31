package com.finverse.beneficiaries;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BeneficiarySanctionsCheck
 */
public interface BeneficiarySanctionsCheckService {

    List<BeneficiarySanctionsCheckDto> getByTenant(UUID tenantId);

    List<BeneficiarySanctionsCheckDto> getByUser(UUID userId);

    BeneficiarySanctionsCheckDto create(BeneficiarySanctionsCheckDto dto);

    BeneficiarySanctionsCheckDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BeneficiarySanctionsCheckDto> listAll();
}
