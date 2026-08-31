package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FedwireFundsTransferRepository extends JpaRepository<FedwireFundsTransfer, UUID> {
    List<FedwireFundsTransfer> findByUserId(UUID userId);
    Optional<FedwireFundsTransfer> findBySettlementRef(String ref);
    List<FedwireFundsTransfer> findByLifecycleStatus(String status);
}
