package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for RegulatoryInquiryDossier
 */
public interface RegulatoryInquiryDossierService {

    List<RegulatoryInquiryDossierDto> getByTenant(UUID tenantId);

    List<RegulatoryInquiryDossierDto> getByUser(UUID userId);

    RegulatoryInquiryDossierDto create(RegulatoryInquiryDossierDto dto);

    RegulatoryInquiryDossierDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<RegulatoryInquiryDossierDto> listAll();
}
