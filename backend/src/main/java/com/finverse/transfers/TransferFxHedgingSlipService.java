package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TransferFxHedgingSlip
 */
public interface TransferFxHedgingSlipService {

    List<TransferFxHedgingSlipDto> getByTenant(UUID tenantId);

    List<TransferFxHedgingSlipDto> getByUser(UUID userId);

    TransferFxHedgingSlipDto create(TransferFxHedgingSlipDto dto);

    TransferFxHedgingSlipDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TransferFxHedgingSlipDto> listAll();
}
