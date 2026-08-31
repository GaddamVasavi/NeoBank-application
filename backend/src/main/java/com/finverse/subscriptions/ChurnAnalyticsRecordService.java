package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ChurnAnalyticsRecord
 */
public interface ChurnAnalyticsRecordService {

    List<ChurnAnalyticsRecordDto> getByTenant(UUID tenantId);

    List<ChurnAnalyticsRecordDto> getByUser(UUID userId);

    ChurnAnalyticsRecordDto create(ChurnAnalyticsRecordDto dto);

    ChurnAnalyticsRecordDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ChurnAnalyticsRecordDto> listAll();
}
