package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UsageMeteredBillingRecord
 */
public interface UsageMeteredBillingRecordService {

    List<UsageMeteredBillingRecordDto> getByTenant(UUID tenantId);

    List<UsageMeteredBillingRecordDto> getByUser(UUID userId);

    UsageMeteredBillingRecordDto create(UsageMeteredBillingRecordDto dto);

    UsageMeteredBillingRecordDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UsageMeteredBillingRecordDto> listAll();
}
