package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralSecuritiesDepositoryRepository extends JpaRepository<CentralSecuritiesDepository, UUID> {
    List<CentralSecuritiesDepository> findByUserId(UUID userId);
    Optional<CentralSecuritiesDepository> findBySettlementRef(String ref);
    List<CentralSecuritiesDepository> findByLifecycleStatus(String status);
}
