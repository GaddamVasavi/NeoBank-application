package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface CardIssuingWebhookEventLogService {
    List<CardIssuingWebhookEventLogDto> getByUser(UUID userId);
    CardIssuingWebhookEventLogDto create(CardIssuingWebhookEventLogDto dto);
    CardIssuingWebhookEventLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CardIssuingWebhookEventLogDto> listAll();
}
