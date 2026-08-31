package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DelinquentDebtorRecoveryRepository extends JpaRepository<DelinquentDebtorRecovery, UUID> {
    List<DelinquentDebtorRecovery> findByUserId(UUID userId);
    Optional<DelinquentDebtorRecovery> findByDossierReference(String ref);
    List<DelinquentDebtorRecovery> findByOperationalStatus(String status);
}
