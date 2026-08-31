package com.finverse.analytics;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for NetInterestMarginAnalytics
 */
public interface NetInterestMarginAnalyticsService {

    List<NetInterestMarginAnalyticsDto> getByTenant(UUID tenantId);

    List<NetInterestMarginAnalyticsDto> getByUser(UUID userId);

    NetInterestMarginAnalyticsDto create(NetInterestMarginAnalyticsDto dto);

    NetInterestMarginAnalyticsDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<NetInterestMarginAnalyticsDto> listAll();
}
