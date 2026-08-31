package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BillOfExchangeAcceptanceRepository extends JpaRepository<BillOfExchangeAcceptance, UUID> {
    List<BillOfExchangeAcceptance> findByUserId(UUID userId);
    Optional<BillOfExchangeAcceptance> findBySettlementRef(String ref);
    List<BillOfExchangeAcceptance> findByLifecycleStatus(String status);
}
