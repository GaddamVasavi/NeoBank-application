package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardFraudAlertRuleRepository extends JpaRepository<CardFraudAlertRule, UUID> {
    List<CardFraudAlertRule> findByUserId(UUID userId);
    Optional<CardFraudAlertRule> findByRecordKey(String recordKey);
    List<CardFraudAlertRule> findByStatus(String status);
}
