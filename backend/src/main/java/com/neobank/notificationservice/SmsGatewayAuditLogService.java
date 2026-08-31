package com.neobank.notificationservice;
import java.util.List; import java.util.UUID;
public interface SmsGatewayAuditLogService {
    List<SmsGatewayAuditLogDto> getByUser(UUID userId);
    SmsGatewayAuditLogDto create(SmsGatewayAuditLogDto dto);
    SmsGatewayAuditLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SmsGatewayAuditLogDto> listAll();
}
