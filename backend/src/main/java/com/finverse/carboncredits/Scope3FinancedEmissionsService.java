package com.finverse.carboncredits;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for Scope3FinancedEmissions
 */
public interface Scope3FinancedEmissionsService {

    List<Scope3FinancedEmissionsDto> getByTenant(UUID tenantId);

    List<Scope3FinancedEmissionsDto> getByUser(UUID userId);

    Scope3FinancedEmissionsDto create(Scope3FinancedEmissionsDto dto);

    Scope3FinancedEmissionsDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<Scope3FinancedEmissionsDto> listAll();
}
