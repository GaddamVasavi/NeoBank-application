package com.finverse.beneficiaries;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BeneficiaryCoolingPeriod
 */
public interface BeneficiaryCoolingPeriodService {

    List<BeneficiaryCoolingPeriodDto> getByTenant(UUID tenantId);

    List<BeneficiaryCoolingPeriodDto> getByUser(UUID userId);

    BeneficiaryCoolingPeriodDto create(BeneficiaryCoolingPeriodDto dto);

    BeneficiaryCoolingPeriodDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BeneficiaryCoolingPeriodDto> listAll();
}
