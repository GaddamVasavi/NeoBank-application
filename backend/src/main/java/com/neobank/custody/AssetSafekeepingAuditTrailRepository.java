package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AssetSafekeepingAuditTrailRepository extends JpaRepository<AssetSafekeepingAuditTrail, UUID> {
    List<AssetSafekeepingAuditTrail> findByUserId(UUID userId);
    Optional<AssetSafekeepingAuditTrail> findBySettlementRef(String ref);
    List<AssetSafekeepingAuditTrail> findByLifecycleStatus(String status);
}
