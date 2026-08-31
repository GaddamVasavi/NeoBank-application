package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for LoanApplicationDossier
 */
public interface LoanApplicationDossierService {

    List<LoanApplicationDossierDto> getByTenant(UUID tenantId);

    List<LoanApplicationDossierDto> getByUser(UUID userId);

    LoanApplicationDossierDto create(LoanApplicationDossierDto dto);

    LoanApplicationDossierDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<LoanApplicationDossierDto> listAll();
}
