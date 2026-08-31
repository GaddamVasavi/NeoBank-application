package com.finverse.carboncredits;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EuTaxonomyGreenLoanAlign
 */
public interface EuTaxonomyGreenLoanAlignService {

    List<EuTaxonomyGreenLoanAlignDto> getByTenant(UUID tenantId);

    List<EuTaxonomyGreenLoanAlignDto> getByUser(UUID userId);

    EuTaxonomyGreenLoanAlignDto create(EuTaxonomyGreenLoanAlignDto dto);

    EuTaxonomyGreenLoanAlignDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EuTaxonomyGreenLoanAlignDto> listAll();
}
