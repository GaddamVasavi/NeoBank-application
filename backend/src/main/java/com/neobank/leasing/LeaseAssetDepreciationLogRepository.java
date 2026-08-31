package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LeaseAssetDepreciationLogRepository extends JpaRepository<LeaseAssetDepreciationLog, UUID> {
    List<LeaseAssetDepreciationLog> findByUserId(UUID userId);
    Optional<LeaseAssetDepreciationLog> findByDossierReference(String ref);
    List<LeaseAssetDepreciationLog> findByOperationalStatus(String status);
}
