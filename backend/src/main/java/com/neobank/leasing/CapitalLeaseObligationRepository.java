package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CapitalLeaseObligationRepository extends JpaRepository<CapitalLeaseObligation, UUID> {
    List<CapitalLeaseObligation> findByUserId(UUID userId);
    Optional<CapitalLeaseObligation> findByDossierReference(String ref);
    List<CapitalLeaseObligation> findByOperationalStatus(String status);
}
