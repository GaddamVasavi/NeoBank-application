package com.finverse.invoices;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DunningScheduleWorkflow
 */
public interface DunningScheduleWorkflowService {

    List<DunningScheduleWorkflowDto> getByTenant(UUID tenantId);

    List<DunningScheduleWorkflowDto> getByUser(UUID userId);

    DunningScheduleWorkflowDto create(DunningScheduleWorkflowDto dto);

    DunningScheduleWorkflowDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DunningScheduleWorkflowDto> listAll();
}
