package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PrimaryDealerAuctionBidRepository extends JpaRepository<PrimaryDealerAuctionBid, UUID> {
    List<PrimaryDealerAuctionBid> findByUserId(UUID userId);
    Optional<PrimaryDealerAuctionBid> findByInstitutionalRef(String ref);
    List<PrimaryDealerAuctionBid> findByExecutionStatus(String status);
}
