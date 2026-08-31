package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SovereignDebtHoldingAssetRepository extends JpaRepository<SovereignDebtHoldingAsset, UUID> {
    List<SovereignDebtHoldingAsset> findByUserId(UUID userId);
    Optional<SovereignDebtHoldingAsset> findByInstitutionalRef(String ref);
    List<SovereignDebtHoldingAsset> findByExecutionStatus(String status);
}
