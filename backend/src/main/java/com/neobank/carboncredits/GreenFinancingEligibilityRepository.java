package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface GreenFinancingEligibilityRepository extends JpaRepository<GreenFinancingEligibility, UUID> {
    List<GreenFinancingEligibility> findByUserId(UUID userId);
    Optional<GreenFinancingEligibility> findByProtocolReference(String ref);
    List<GreenFinancingEligibility> findByOperationalState(String state);
}
