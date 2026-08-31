package com.neobank.bonds;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InflationIndexedBondAssetRepository extends JpaRepository<InflationIndexedBondAsset, UUID> {
    List<InflationIndexedBondAsset> findByUserId(UUID userId);
    Optional<InflationIndexedBondAsset> findByClearingKey(String key);
    List<InflationIndexedBondAsset> findByAuditStatus(String status);
}
