package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SyndicatedRepaymentWaterfallRepository extends JpaRepository<SyndicatedRepaymentWaterfall, UUID> {
    List<SyndicatedRepaymentWaterfall> findByUserId(UUID userId);
    Optional<SyndicatedRepaymentWaterfall> findByProtocolReference(String ref);
    List<SyndicatedRepaymentWaterfall> findByOperationalState(String state);
}
