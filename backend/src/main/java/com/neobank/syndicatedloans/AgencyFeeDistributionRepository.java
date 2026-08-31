package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AgencyFeeDistributionRepository extends JpaRepository<AgencyFeeDistribution, UUID> {
    List<AgencyFeeDistribution> findByUserId(UUID userId);
    Optional<AgencyFeeDistribution> findByProtocolReference(String ref);
    List<AgencyFeeDistribution> findByOperationalState(String state);
}
