package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PerDiemAllowanceSchedule
 */
public interface PerDiemAllowanceScheduleService {

    List<PerDiemAllowanceScheduleDto> getByTenant(UUID tenantId);

    List<PerDiemAllowanceScheduleDto> getByUser(UUID userId);

    PerDiemAllowanceScheduleDto create(PerDiemAllowanceScheduleDto dto);

    PerDiemAllowanceScheduleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PerDiemAllowanceScheduleDto> listAll();
}
