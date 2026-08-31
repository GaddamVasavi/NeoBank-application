package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SyndicatedLoanFacilityRepository extends JpaRepository<SyndicatedLoanFacility, UUID> {
    List<SyndicatedLoanFacility> findByUserId(UUID userId);
    Optional<SyndicatedLoanFacility> findByTrackingCode(String code);
    List<SyndicatedLoanFacility> findByStateFlag(String stateFlag);
}
