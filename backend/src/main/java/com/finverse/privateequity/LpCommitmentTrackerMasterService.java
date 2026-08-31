package com.finverse.privateequity;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for LpCommitmentTrackerMaster
 */
public interface LpCommitmentTrackerMasterService {

    List<LpCommitmentTrackerMasterDto> getByTenant(UUID tenantId);

    List<LpCommitmentTrackerMasterDto> getByUser(UUID userId);

    LpCommitmentTrackerMasterDto create(LpCommitmentTrackerMasterDto dto);

    LpCommitmentTrackerMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<LpCommitmentTrackerMasterDto> listAll();
}
