package com.neobank.analyticsengine;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RiskWeightedAssetModelRepository extends JpaRepository<RiskWeightedAssetModel, UUID> {
    List<RiskWeightedAssetModel> findByUserId(UUID userId);
    Optional<RiskWeightedAssetModel> findByCoreReference(String ref);
    List<RiskWeightedAssetModel> findByProcessingStatus(String status);
}
