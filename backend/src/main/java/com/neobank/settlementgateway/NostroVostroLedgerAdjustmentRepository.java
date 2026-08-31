package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NostroVostroLedgerAdjustmentRepository extends JpaRepository<NostroVostroLedgerAdjustment, UUID> {
    List<NostroVostroLedgerAdjustment> findByUserId(UUID userId);
    Optional<NostroVostroLedgerAdjustment> findByGatewayReference(String ref);
    List<NostroVostroLedgerAdjustment> findBySettlementState(String state);
}
