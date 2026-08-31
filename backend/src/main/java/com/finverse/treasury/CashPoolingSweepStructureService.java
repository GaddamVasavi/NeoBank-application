package com.finverse.treasury;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CashPoolingSweepStructure
 */
public interface CashPoolingSweepStructureService {

    List<CashPoolingSweepStructureDto> getByTenant(UUID tenantId);

    List<CashPoolingSweepStructureDto> getByUser(UUID userId);

    CashPoolingSweepStructureDto create(CashPoolingSweepStructureDto dto);

    CashPoolingSweepStructureDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CashPoolingSweepStructureDto> listAll();
}
