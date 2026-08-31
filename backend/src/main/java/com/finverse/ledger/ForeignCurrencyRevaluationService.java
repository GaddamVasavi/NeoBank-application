package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ForeignCurrencyRevaluation
 */
public interface ForeignCurrencyRevaluationService {

    List<ForeignCurrencyRevaluationDto> getByTenant(UUID tenantId);

    List<ForeignCurrencyRevaluationDto> getByUser(UUID userId);

    ForeignCurrencyRevaluationDto create(ForeignCurrencyRevaluationDto dto);

    ForeignCurrencyRevaluationDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ForeignCurrencyRevaluationDto> listAll();
}
