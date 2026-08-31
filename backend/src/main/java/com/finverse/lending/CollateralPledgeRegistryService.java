package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CollateralPledgeRegistry
 */
public interface CollateralPledgeRegistryService {

    List<CollateralPledgeRegistryDto> getByTenant(UUID tenantId);

    List<CollateralPledgeRegistryDto> getByUser(UUID userId);

    CollateralPledgeRegistryDto create(CollateralPledgeRegistryDto dto);

    CollateralPledgeRegistryDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CollateralPledgeRegistryDto> listAll();
}
