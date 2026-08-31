package com.finverse.privateequity;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DistributionWaterfallLedger
 */
public interface DistributionWaterfallLedgerService {

    List<DistributionWaterfallLedgerDto> getByTenant(UUID tenantId);

    List<DistributionWaterfallLedgerDto> getByUser(UUID userId);

    DistributionWaterfallLedgerDto create(DistributionWaterfallLedgerDto dto);

    DistributionWaterfallLedgerDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DistributionWaterfallLedgerDto> listAll();
}
