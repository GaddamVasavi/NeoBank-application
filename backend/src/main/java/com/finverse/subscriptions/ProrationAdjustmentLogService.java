package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ProrationAdjustmentLog
 */
public interface ProrationAdjustmentLogService {

    List<ProrationAdjustmentLogDto> getByTenant(UUID tenantId);

    List<ProrationAdjustmentLogDto> getByUser(UUID userId);

    ProrationAdjustmentLogDto create(ProrationAdjustmentLogDto dto);

    ProrationAdjustmentLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ProrationAdjustmentLogDto> listAll();
}
