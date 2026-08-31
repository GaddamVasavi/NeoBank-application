package com.neobank.bonds;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ConvertibleBondHybridAssetRepository extends JpaRepository<ConvertibleBondHybridAsset, UUID> {
    List<ConvertibleBondHybridAsset> findByUserId(UUID userId);
    Optional<ConvertibleBondHybridAsset> findByClearingKey(String key);
    List<ConvertibleBondHybridAsset> findByAuditStatus(String status);
}
