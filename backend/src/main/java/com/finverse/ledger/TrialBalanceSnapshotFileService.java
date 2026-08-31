package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TrialBalanceSnapshotFile
 */
public interface TrialBalanceSnapshotFileService {

    List<TrialBalanceSnapshotFileDto> getByTenant(UUID tenantId);

    List<TrialBalanceSnapshotFileDto> getByUser(UUID userId);

    TrialBalanceSnapshotFileDto create(TrialBalanceSnapshotFileDto dto);

    TrialBalanceSnapshotFileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TrialBalanceSnapshotFileDto> listAll();
}
