package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CarbonCreditRegistryEntryRepository extends JpaRepository<CarbonCreditRegistryEntry, UUID> {
    List<CarbonCreditRegistryEntry> findByUserId(UUID userId);
    Optional<CarbonCreditRegistryEntry> findByProtocolReference(String ref);
    List<CarbonCreditRegistryEntry> findByOperationalState(String state);
}
