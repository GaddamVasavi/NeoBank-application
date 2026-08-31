package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EstatePlanningTrustRepository extends JpaRepository<EstatePlanningTrust, UUID> {
    List<EstatePlanningTrust> findByUserId(UUID userId);
    Optional<EstatePlanningTrust> findByTrackingCode(String code);
    List<EstatePlanningTrust> findByStateFlag(String stateFlag);
}
