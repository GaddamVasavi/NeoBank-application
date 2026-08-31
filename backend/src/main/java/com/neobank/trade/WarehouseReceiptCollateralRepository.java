package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WarehouseReceiptCollateralRepository extends JpaRepository<WarehouseReceiptCollateral, UUID> {
    List<WarehouseReceiptCollateral> findByUserId(UUID userId);
    Optional<WarehouseReceiptCollateral> findBySettlementRef(String ref);
    List<WarehouseReceiptCollateral> findByLifecycleStatus(String status);
}
