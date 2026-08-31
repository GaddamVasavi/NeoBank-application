package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for KycPeriodicRefreshSchedule
 */
public interface KycPeriodicRefreshScheduleService {

    List<KycPeriodicRefreshScheduleDto> getByTenant(UUID tenantId);

    List<KycPeriodicRefreshScheduleDto> getByUser(UUID userId);

    KycPeriodicRefreshScheduleDto create(KycPeriodicRefreshScheduleDto dto);

    KycPeriodicRefreshScheduleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<KycPeriodicRefreshScheduleDto> listAll();
}
