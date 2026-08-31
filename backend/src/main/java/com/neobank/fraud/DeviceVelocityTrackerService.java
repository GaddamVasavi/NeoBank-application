package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface DeviceVelocityTrackerService {
    List<DeviceVelocityTrackerDto> getByUser(UUID userId);
    DeviceVelocityTrackerDto create(DeviceVelocityTrackerDto dto);
    DeviceVelocityTrackerDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
