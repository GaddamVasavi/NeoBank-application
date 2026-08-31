package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SustainabilityLinkedBondRepository extends JpaRepository<SustainabilityLinkedBond, UUID> {
    List<SustainabilityLinkedBond> findByUserId(UUID userId);
    Optional<SustainabilityLinkedBond> findByProtocolReference(String ref);
    List<SustainabilityLinkedBond> findByOperationalState(String state);
}
