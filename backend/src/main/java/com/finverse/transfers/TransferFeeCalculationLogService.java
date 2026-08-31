package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TransferFeeCalculationLog
 */
public interface TransferFeeCalculationLogService {

    List<TransferFeeCalculationLogDto> getByTenant(UUID tenantId);

    List<TransferFeeCalculationLogDto> getByUser(UUID userId);

    TransferFeeCalculationLogDto create(TransferFeeCalculationLogDto dto);

    TransferFeeCalculationLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TransferFeeCalculationLogDto> listAll();
}
