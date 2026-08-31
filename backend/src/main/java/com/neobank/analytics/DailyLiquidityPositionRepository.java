package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DailyLiquidityPositionRepository extends JpaRepository<DailyLiquidityPosition, UUID> {
    List<DailyLiquidityPosition> findByUserId(UUID userId);
    Optional<DailyLiquidityPosition> findByRecordKey(String recordKey);
    List<DailyLiquidityPosition> findByStatus(String status);
}
