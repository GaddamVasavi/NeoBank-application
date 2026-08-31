package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface ClusterNodeHealthTelemetryService {
    List<ClusterNodeHealthTelemetryDto> getByUser(UUID userId);
    ClusterNodeHealthTelemetryDto create(ClusterNodeHealthTelemetryDto dto);
    ClusterNodeHealthTelemetryDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ClusterNodeHealthTelemetryDto> listAll();
}
