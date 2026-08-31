package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RealTimeGrossSettlementRepository extends JpaRepository<RealTimeGrossSettlement, UUID> {
    List<RealTimeGrossSettlement> findByUserId(UUID userId);
    Optional<RealTimeGrossSettlement> findBySettlementRef(String ref);
    List<RealTimeGrossSettlement> findByLifecycleStatus(String status);
}
