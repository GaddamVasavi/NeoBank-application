package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ThreeWayLedgerReconBreak
 */
public interface ThreeWayLedgerReconBreakService {

    List<ThreeWayLedgerReconBreakDto> getByTenant(UUID tenantId);

    List<ThreeWayLedgerReconBreakDto> getByUser(UUID userId);

    ThreeWayLedgerReconBreakDto create(ThreeWayLedgerReconBreakDto dto);

    ThreeWayLedgerReconBreakDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ThreeWayLedgerReconBreakDto> listAll();
}
