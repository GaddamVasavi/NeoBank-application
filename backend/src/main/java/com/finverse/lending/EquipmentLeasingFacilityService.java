package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EquipmentLeasingFacility
 */
public interface EquipmentLeasingFacilityService {

    List<EquipmentLeasingFacilityDto> getByTenant(UUID tenantId);

    List<EquipmentLeasingFacilityDto> getByUser(UUID userId);

    EquipmentLeasingFacilityDto create(EquipmentLeasingFacilityDto dto);

    EquipmentLeasingFacilityDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EquipmentLeasingFacilityDto> listAll();
}
