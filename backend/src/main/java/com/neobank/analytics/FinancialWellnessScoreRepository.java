package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FinancialWellnessScoreRepository extends JpaRepository<FinancialWellnessScore, UUID> {
    List<FinancialWellnessScore> findByUserId(UUID userId);
    Optional<FinancialWellnessScore> findByRecordKey(String recordKey);
    List<FinancialWellnessScore> findByStatus(String status);
}
