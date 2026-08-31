package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CurrencyHedgingContractRepository extends JpaRepository<CurrencyHedgingContract, UUID> {
    List<CurrencyHedgingContract> findBySourceAccountId(UUID accountId);
    Optional<CurrencyHedgingContract> findByTrackingNumber(String trackingNumber);
    List<CurrencyHedgingContract> findByStatus(String status);
}
