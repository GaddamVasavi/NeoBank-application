package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BondConvexityMetricRecordRepository extends JpaRepository<BondConvexityMetricRecord, UUID> {
    List<BondConvexityMetricRecord> findByUserId(UUID userId);
    Optional<BondConvexityMetricRecord> findByInstitutionalRef(String ref);
    List<BondConvexityMetricRecord> findByExecutionStatus(String status);
}
