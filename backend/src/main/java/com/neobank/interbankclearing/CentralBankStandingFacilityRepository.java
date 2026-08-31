package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralBankStandingFacilityRepository extends JpaRepository<CentralBankStandingFacility, UUID> {
    List<CentralBankStandingFacility> findByUserId(UUID userId);
    Optional<CentralBankStandingFacility> findByProtocolReference(String ref);
    List<CentralBankStandingFacility> findByOperationalState(String state);
}
