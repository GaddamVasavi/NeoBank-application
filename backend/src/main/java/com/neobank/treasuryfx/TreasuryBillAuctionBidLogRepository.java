package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TreasuryBillAuctionBidLogRepository extends JpaRepository<TreasuryBillAuctionBidLog, UUID> {
    List<TreasuryBillAuctionBidLog> findByUserId(UUID userId);
    Optional<TreasuryBillAuctionBidLog> findByInstitutionalRef(String ref);
    List<TreasuryBillAuctionBidLog> findByExecutionStatus(String status);
}
