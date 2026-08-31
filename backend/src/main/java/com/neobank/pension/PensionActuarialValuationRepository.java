package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PensionActuarialValuationRepository extends JpaRepository<PensionActuarialValuation, UUID> {
    List<PensionActuarialValuation> findByUserId(UUID userId);
    Optional<PensionActuarialValuation> findBySettlementRef(String ref);
    List<PensionActuarialValuation> findByLifecycleStatus(String status);
}
