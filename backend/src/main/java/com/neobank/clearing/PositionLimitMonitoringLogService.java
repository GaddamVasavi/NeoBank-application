package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface PositionLimitMonitoringLogService {
    List<PositionLimitMonitoringLogDto> getByUser(UUID userId);
    PositionLimitMonitoringLogDto create(PositionLimitMonitoringLogDto dto);
    PositionLimitMonitoringLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PositionLimitMonitoringLogDto> listAll();
}
