package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralBankAuctionTenderRepository extends JpaRepository<CentralBankAuctionTender, UUID> {
    List<CentralBankAuctionTender> findByUserId(UUID userId);
    Optional<CentralBankAuctionTender> findByClearingIdentifier(String id);
    List<CentralBankAuctionTender> findBySettlementStatus(String status);
}
