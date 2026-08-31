package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ReimbursementPayoutBatch
 */
public interface ReimbursementPayoutBatchService {

    List<ReimbursementPayoutBatchDto> getByTenant(UUID tenantId);

    List<ReimbursementPayoutBatchDto> getByUser(UUID userId);

    ReimbursementPayoutBatchDto create(ReimbursementPayoutBatchDto dto);

    ReimbursementPayoutBatchDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ReimbursementPayoutBatchDto> listAll();
}
