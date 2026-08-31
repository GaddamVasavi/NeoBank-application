package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for LoanAmortizationSchedule
 */
public interface LoanAmortizationScheduleService {

    List<LoanAmortizationScheduleDto> getByTenant(UUID tenantId);

    List<LoanAmortizationScheduleDto> getByUser(UUID userId);

    LoanAmortizationScheduleDto create(LoanAmortizationScheduleDto dto);

    LoanAmortizationScheduleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<LoanAmortizationScheduleDto> listAll();
}
