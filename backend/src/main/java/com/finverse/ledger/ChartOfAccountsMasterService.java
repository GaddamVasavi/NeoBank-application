package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ChartOfAccountsMaster
 */
public interface ChartOfAccountsMasterService {

    List<ChartOfAccountsMasterDto> getByTenant(UUID tenantId);

    List<ChartOfAccountsMasterDto> getByUser(UUID userId);

    ChartOfAccountsMasterDto create(ChartOfAccountsMasterDto dto);

    ChartOfAccountsMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ChartOfAccountsMasterDto> listAll();
}
