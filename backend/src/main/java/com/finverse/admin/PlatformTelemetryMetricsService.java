package com.finverse.admin;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PlatformTelemetryMetrics
 */
public interface PlatformTelemetryMetricsService {

    List<PlatformTelemetryMetricsDto> getByTenant(UUID tenantId);

    List<PlatformTelemetryMetricsDto> getByUser(UUID userId);

    PlatformTelemetryMetricsDto create(PlatformTelemetryMetricsDto dto);

    PlatformTelemetryMetricsDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PlatformTelemetryMetricsDto> listAll();
}
