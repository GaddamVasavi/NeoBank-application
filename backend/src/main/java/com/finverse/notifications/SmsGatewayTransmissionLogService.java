package com.finverse.notifications;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SmsGatewayTransmissionLog
 */
public interface SmsGatewayTransmissionLogService {

    List<SmsGatewayTransmissionLogDto> getByTenant(UUID tenantId);

    List<SmsGatewayTransmissionLogDto> getByUser(UUID userId);

    SmsGatewayTransmissionLogDto create(SmsGatewayTransmissionLogDto dto);

    SmsGatewayTransmissionLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SmsGatewayTransmissionLogDto> listAll();
}
