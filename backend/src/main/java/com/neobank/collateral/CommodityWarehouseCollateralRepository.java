package com.neobank.collateral;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CommodityWarehouseCollateralRepository extends JpaRepository<CommodityWarehouseCollateral, UUID> {
    List<CommodityWarehouseCollateral> findByUserId(UUID userId);
    Optional<CommodityWarehouseCollateral> findByCoreReference(String ref);
    List<CommodityWarehouseCollateral> findByProcessingStatus(String status);
}
