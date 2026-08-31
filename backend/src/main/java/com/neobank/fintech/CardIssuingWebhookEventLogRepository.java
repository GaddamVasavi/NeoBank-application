package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardIssuingWebhookEventLogRepository extends JpaRepository<CardIssuingWebhookEventLog, UUID> {
    List<CardIssuingWebhookEventLog> findByUserId(UUID userId);
    Optional<CardIssuingWebhookEventLog> findByInstitutionalRef(String ref);
    List<CardIssuingWebhookEventLog> findByExecutionStatus(String status);
}
