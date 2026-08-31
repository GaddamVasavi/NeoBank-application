package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CorporateCardExpenseMatch
 */
public interface CorporateCardExpenseMatchService {

    List<CorporateCardExpenseMatchDto> getByTenant(UUID tenantId);

    List<CorporateCardExpenseMatchDto> getByUser(UUID userId);

    CorporateCardExpenseMatchDto create(CorporateCardExpenseMatchDto dto);

    CorporateCardExpenseMatchDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CorporateCardExpenseMatchDto> listAll();
}
