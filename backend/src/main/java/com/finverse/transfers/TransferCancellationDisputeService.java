package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TransferCancellationDispute
 */
public interface TransferCancellationDisputeService {

    List<TransferCancellationDisputeDto> getByTenant(UUID tenantId);

    List<TransferCancellationDisputeDto> getByUser(UUID userId);

    TransferCancellationDisputeDto create(TransferCancellationDisputeDto dto);

    TransferCancellationDisputeDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TransferCancellationDisputeDto> listAll();
}
