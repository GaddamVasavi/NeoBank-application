package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SyndicatedFacilityBookingRepository extends JpaRepository<SyndicatedFacilityBooking, UUID> {
    List<SyndicatedFacilityBooking> findByUserId(UUID userId);
    Optional<SyndicatedFacilityBooking> findByProtocolReference(String ref);
    List<SyndicatedFacilityBooking> findByOperationalState(String state);
}
