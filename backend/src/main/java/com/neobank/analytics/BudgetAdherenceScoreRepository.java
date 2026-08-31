package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BudgetAdherenceScoreRepository extends JpaRepository<BudgetAdherenceScore, UUID> {
    List<BudgetAdherenceScore> findByUserId(UUID userId);
    Optional<BudgetAdherenceScore> findByRecordKey(String recordKey);
    List<BudgetAdherenceScore> findByStatus(String status);
}
