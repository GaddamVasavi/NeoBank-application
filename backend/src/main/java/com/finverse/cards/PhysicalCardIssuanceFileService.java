package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PhysicalCardIssuanceFile
 */
public interface PhysicalCardIssuanceFileService {

    List<PhysicalCardIssuanceFileDto> getByTenant(UUID tenantId);

    List<PhysicalCardIssuanceFileDto> getByUser(UUID userId);

    PhysicalCardIssuanceFileDto create(PhysicalCardIssuanceFileDto dto);

    PhysicalCardIssuanceFileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PhysicalCardIssuanceFileDto> listAll();
}
