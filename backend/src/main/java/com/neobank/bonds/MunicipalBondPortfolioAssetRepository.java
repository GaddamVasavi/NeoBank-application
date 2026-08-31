package com.neobank.bonds;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MunicipalBondPortfolioAssetRepository extends JpaRepository<MunicipalBondPortfolioAsset, UUID> {
    List<MunicipalBondPortfolioAsset> findByUserId(UUID userId);
    Optional<MunicipalBondPortfolioAsset> findByClearingKey(String key);
    List<MunicipalBondPortfolioAsset> findByAuditStatus(String status);
}
