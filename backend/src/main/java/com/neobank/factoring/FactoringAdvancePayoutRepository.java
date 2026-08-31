package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FactoringAdvancePayoutRepository extends JpaRepository<FactoringAdvancePayout, UUID> {
    List<FactoringAdvancePayout> findByUserId(UUID userId);
    Optional<FactoringAdvancePayout> findByDossierReference(String ref);
    List<FactoringAdvancePayout> findByOperationalStatus(String status);
}
