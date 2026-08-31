package com.finverse.tradefinance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for MarineCargoInsurancePolicy
 */
public interface MarineCargoInsurancePolicyService {

    List<MarineCargoInsurancePolicyDto> getByTenant(UUID tenantId);

    List<MarineCargoInsurancePolicyDto> getByUser(UUID userId);

    MarineCargoInsurancePolicyDto create(MarineCargoInsurancePolicyDto dto);

    MarineCargoInsurancePolicyDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<MarineCargoInsurancePolicyDto> listAll();
}
