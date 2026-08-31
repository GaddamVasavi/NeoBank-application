package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CategorySpendingTrendRepository extends JpaRepository<CategorySpendingTrend, UUID> {
    List<CategorySpendingTrend> findByUserId(UUID userId);
    Optional<CategorySpendingTrend> findByRecordKey(String recordKey);
    List<CategorySpendingTrend> findByStatus(String status);
}
