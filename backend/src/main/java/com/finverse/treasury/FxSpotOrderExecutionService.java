package com.finverse.treasury;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FxSpotOrderExecution
 */
public interface FxSpotOrderExecutionService {

    List<FxSpotOrderExecutionDto> getByTenant(UUID tenantId);

    List<FxSpotOrderExecutionDto> getByUser(UUID userId);

    FxSpotOrderExecutionDto create(FxSpotOrderExecutionDto dto);

    FxSpotOrderExecutionDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FxSpotOrderExecutionDto> listAll();
}
