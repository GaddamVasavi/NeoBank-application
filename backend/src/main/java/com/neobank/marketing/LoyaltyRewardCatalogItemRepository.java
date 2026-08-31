package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoyaltyRewardCatalogItemRepository extends JpaRepository<LoyaltyRewardCatalogItem, UUID> {
    List<LoyaltyRewardCatalogItem> findByUserId(UUID userId);
    Optional<LoyaltyRewardCatalogItem> findByTrackingCode(String code);
    List<LoyaltyRewardCatalogItem> findByStateFlag(String stateFlag);
}
