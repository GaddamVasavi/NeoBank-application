package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TradeCompressionCycleLogRepository extends JpaRepository<TradeCompressionCycleLog, UUID> {
    List<TradeCompressionCycleLog> findByUserId(UUID userId);
    Optional<TradeCompressionCycleLog> findByInstitutionalRef(String ref);
    List<TradeCompressionCycleLog> findByExecutionStatus(String status);
}
