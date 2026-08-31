package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for NonPerformingLoanWorkout
 */
public interface NonPerformingLoanWorkoutService {

    List<NonPerformingLoanWorkoutDto> getByTenant(UUID tenantId);

    List<NonPerformingLoanWorkoutDto> getByUser(UUID userId);

    NonPerformingLoanWorkoutDto create(NonPerformingLoanWorkoutDto dto);

    NonPerformingLoanWorkoutDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<NonPerformingLoanWorkoutDto> listAll();
}
