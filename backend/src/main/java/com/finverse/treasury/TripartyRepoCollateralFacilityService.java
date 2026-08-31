package com.finverse.treasury;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TripartyRepoCollateralFacility
 */
public interface TripartyRepoCollateralFacilityService {

    List<TripartyRepoCollateralFacilityDto> getByTenant(UUID tenantId);

    List<TripartyRepoCollateralFacilityDto> getByUser(UUID userId);

    TripartyRepoCollateralFacilityDto create(TripartyRepoCollateralFacilityDto dto);

    TripartyRepoCollateralFacilityDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TripartyRepoCollateralFacilityDto> listAll();
}
