package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface SystemHealthTelemetryService {
    List<SystemHealthTelemetryDto> getByUser(UUID userId);
    SystemHealthTelemetryDto create(SystemHealthTelemetryDto dto);
    SystemHealthTelemetryDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SystemHealthTelemetryDto> listAll();
}
