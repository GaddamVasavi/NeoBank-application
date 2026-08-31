package com.finverse.analytics;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CreditRiskMigrationMatrix
 */
public interface CreditRiskMigrationMatrixService {

    List<CreditRiskMigrationMatrixDto> getByTenant(UUID tenantId);

    List<CreditRiskMigrationMatrixDto> getByUser(UUID userId);

    CreditRiskMigrationMatrixDto create(CreditRiskMigrationMatrixDto dto);

    CreditRiskMigrationMatrixDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CreditRiskMigrationMatrixDto> listAll();
}
