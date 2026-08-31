package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InterbankNettingCycleRepository extends JpaRepository<InterbankNettingCycle, UUID> {
    List<InterbankNettingCycle> findByUserId(UUID userId);
    Optional<InterbankNettingCycle> findBySettlementRef(String ref);
    List<InterbankNettingCycle> findByLifecycleStatus(String status);
}
