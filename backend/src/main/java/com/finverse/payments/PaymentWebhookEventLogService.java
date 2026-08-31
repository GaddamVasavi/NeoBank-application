package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentWebhookEventLog
 */
public interface PaymentWebhookEventLogService {

    List<PaymentWebhookEventLogDto> getByTenant(UUID tenantId);

    List<PaymentWebhookEventLogDto> getByUser(UUID userId);

    PaymentWebhookEventLogDto create(PaymentWebhookEventLogDto dto);

    PaymentWebhookEventLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentWebhookEventLogDto> listAll();
}
