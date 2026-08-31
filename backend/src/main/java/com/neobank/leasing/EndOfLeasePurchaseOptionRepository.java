package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EndOfLeasePurchaseOptionRepository extends JpaRepository<EndOfLeasePurchaseOption, UUID> {
    List<EndOfLeasePurchaseOption> findByUserId(UUID userId);
    Optional<EndOfLeasePurchaseOption> findByDossierReference(String ref);
    List<EndOfLeasePurchaseOption> findByOperationalStatus(String status);
}
