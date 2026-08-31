package com.neobank.treasury;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LiquidityLadderReportRepository extends JpaRepository<LiquidityLadderReport, UUID> {
    List<LiquidityLadderReport> findByUserId(UUID userId);
    Optional<LiquidityLadderReport> findByIdentifierCode(String code);
    List<LiquidityLadderReport> findByStatus(String status);
}
