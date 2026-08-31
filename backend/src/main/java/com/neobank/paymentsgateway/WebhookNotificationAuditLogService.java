package com.neobank.paymentsgateway;
import java.util.List; import java.util.UUID;
public interface WebhookNotificationAuditLogService {
    List<WebhookNotificationAuditLogDto> getByUser(UUID userId);
    WebhookNotificationAuditLogDto create(WebhookNotificationAuditLogDto dto);
    WebhookNotificationAuditLogDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<WebhookNotificationAuditLogDto> listAll();
}
