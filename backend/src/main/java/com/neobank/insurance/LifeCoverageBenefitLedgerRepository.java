package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LifeCoverageBenefitLedgerRepository extends JpaRepository<LifeCoverageBenefitLedger, UUID> {
    List<LifeCoverageBenefitLedger> findByUserId(UUID userId);
    Optional<LifeCoverageBenefitLedger> findByDossierReference(String ref);
    List<LifeCoverageBenefitLedger> findByOperationalStatus(String status);
}
