package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CardSpendLimitRuleRepository extends JpaRepository<CardSpendLimitRule, UUID> {
    List<CardSpendLimitRule> findByUserId(UUID userId);
    Optional<CardSpendLimitRule> findByRecordKey(String recordKey);
    List<CardSpendLimitRule> findByStatus(String status);
}
