package com.finverse.beneficiaries;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BulkPayoutBatchUpload
 */
public interface BulkPayoutBatchUploadService {

    List<BulkPayoutBatchUploadDto> getByTenant(UUID tenantId);

    List<BulkPayoutBatchUploadDto> getByUser(UUID userId);

    BulkPayoutBatchUploadDto create(BulkPayoutBatchUploadDto dto);

    BulkPayoutBatchUploadDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BulkPayoutBatchUploadDto> listAll();
}
