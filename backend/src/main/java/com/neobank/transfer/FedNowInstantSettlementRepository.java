package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FedNowInstantSettlementRepository extends JpaRepository<FedNowInstantSettlement, UUID> {
    List<FedNowInstantSettlement> findBySourceAccountId(UUID accountId);
    Optional<FedNowInstantSettlement> findByTrackingNumber(String trackingNumber);
    List<FedNowInstantSettlement> findByStatus(String status);
}
