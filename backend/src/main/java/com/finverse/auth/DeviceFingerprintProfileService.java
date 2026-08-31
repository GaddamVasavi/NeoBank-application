package com.finverse.auth;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DeviceFingerprintProfile
 */
public interface DeviceFingerprintProfileService {

    List<DeviceFingerprintProfileDto> getByTenant(UUID tenantId);

    List<DeviceFingerprintProfileDto> getByUser(UUID userId);

    DeviceFingerprintProfileDto create(DeviceFingerprintProfileDto dto);

    DeviceFingerprintProfileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DeviceFingerprintProfileDto> listAll();
}
