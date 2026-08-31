package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface HedgeFundSubscriptionRepository extends JpaRepository<HedgeFundSubscription, UUID> {
    List<HedgeFundSubscription> findByUserId(UUID userId);
    Optional<HedgeFundSubscription> findByTrackingCode(String code);
    List<HedgeFundSubscription> findByStateFlag(String stateFlag);
}
