package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NostroVostroReconciliationRepository extends JpaRepository<NostroVostroReconciliation, UUID> {
    List<NostroVostroReconciliation> findByUserId(UUID userId);
    Optional<NostroVostroReconciliation> findBySettlementRef(String ref);
    List<NostroVostroReconciliation> findByLifecycleStatus(String status);
}
