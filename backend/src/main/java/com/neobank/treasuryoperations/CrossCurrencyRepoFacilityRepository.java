package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CrossCurrencyRepoFacilityRepository extends JpaRepository<CrossCurrencyRepoFacility, UUID> {
    List<CrossCurrencyRepoFacility> findByUserId(UUID userId);
    Optional<CrossCurrencyRepoFacility> findByClearingIdentifier(String id);
    List<CrossCurrencyRepoFacility> findBySettlementStatus(String status);
}
