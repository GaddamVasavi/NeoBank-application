package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ShippingConsignmentLedgerRepository extends JpaRepository<ShippingConsignmentLedger, UUID> {
    List<ShippingConsignmentLedger> findByUserId(UUID userId);
    Optional<ShippingConsignmentLedger> findBySettlementRef(String ref);
    List<ShippingConsignmentLedger> findByLifecycleStatus(String status);
}
