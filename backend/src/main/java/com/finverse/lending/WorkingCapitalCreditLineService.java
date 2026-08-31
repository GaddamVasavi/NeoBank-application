package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for WorkingCapitalCreditLine
 */
public interface WorkingCapitalCreditLineService {

    List<WorkingCapitalCreditLineDto> getByTenant(UUID tenantId);

    List<WorkingCapitalCreditLineDto> getByUser(UUID userId);

    WorkingCapitalCreditLineDto create(WorkingCapitalCreditLineDto dto);

    WorkingCapitalCreditLineDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<WorkingCapitalCreditLineDto> listAll();
}
