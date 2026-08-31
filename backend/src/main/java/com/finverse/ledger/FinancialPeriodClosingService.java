package com.finverse.ledger;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FinancialPeriodClosing
 */
public interface FinancialPeriodClosingService {

    List<FinancialPeriodClosingDto> getByTenant(UUID tenantId);

    List<FinancialPeriodClosingDto> getByUser(UUID userId);

    FinancialPeriodClosingDto create(FinancialPeriodClosingDto dto);

    FinancialPeriodClosingDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FinancialPeriodClosingDto> listAll();
}
