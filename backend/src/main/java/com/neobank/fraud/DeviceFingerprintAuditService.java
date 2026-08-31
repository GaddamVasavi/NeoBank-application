package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface DeviceFingerprintAuditService {
    List<DeviceFingerprintAuditDto> getByUser(UUID userId);
    DeviceFingerprintAuditDto create(DeviceFingerprintAuditDto dto);
    DeviceFingerprintAuditDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<DeviceFingerprintAuditDto> listAll();
}
