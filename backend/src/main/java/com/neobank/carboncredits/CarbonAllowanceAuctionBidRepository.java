package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CarbonAllowanceAuctionBidRepository extends JpaRepository<CarbonAllowanceAuctionBid, UUID> {
    List<CarbonAllowanceAuctionBid> findByUserId(UUID userId);
    Optional<CarbonAllowanceAuctionBid> findByProtocolReference(String ref);
    List<CarbonAllowanceAuctionBid> findByOperationalState(String state);
}
