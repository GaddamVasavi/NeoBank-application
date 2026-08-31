package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FundDistributionWaterfallRepository extends JpaRepository<FundDistributionWaterfall, UUID> {
    List<FundDistributionWaterfall> findByUserId(UUID userId);
    Optional<FundDistributionWaterfall> findByProtocolReference(String ref);
    List<FundDistributionWaterfall> findByOperationalState(String state);
}
