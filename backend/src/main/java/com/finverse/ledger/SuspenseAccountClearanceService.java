package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SuspenseAccountClearance
 */
public interface SuspenseAccountClearanceService {

    List<SuspenseAccountClearanceDto> getByTenant(UUID tenantId);

    List<SuspenseAccountClearanceDto> getByUser(UUID userId);

    SuspenseAccountClearanceDto create(SuspenseAccountClearanceDto dto);

    SuspenseAccountClearanceDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SuspenseAccountClearanceDto> listAll();
}
