package com.finverse.carboncredits;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CarbonOffsetRegistrySerial
 */
public interface CarbonOffsetRegistrySerialService {

    List<CarbonOffsetRegistrySerialDto> getByTenant(UUID tenantId);

    List<CarbonOffsetRegistrySerialDto> getByUser(UUID userId);

    CarbonOffsetRegistrySerialDto create(CarbonOffsetRegistrySerialDto dto);

    CarbonOffsetRegistrySerialDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CarbonOffsetRegistrySerialDto> listAll();
}
