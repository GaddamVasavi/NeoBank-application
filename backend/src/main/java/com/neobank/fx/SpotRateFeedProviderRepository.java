package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SpotRateFeedProviderRepository extends JpaRepository<SpotRateFeedProvider, UUID> {
    List<SpotRateFeedProvider> findByUserId(UUID userId);
    Optional<SpotRateFeedProvider> findBySettlementRef(String ref);
    List<SpotRateFeedProvider> findByLifecycleStatus(String status);
}
