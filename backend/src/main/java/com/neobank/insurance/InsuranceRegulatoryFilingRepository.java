package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InsuranceRegulatoryFilingRepository extends JpaRepository<InsuranceRegulatoryFiling, UUID> {
    List<InsuranceRegulatoryFiling> findByUserId(UUID userId);
    Optional<InsuranceRegulatoryFiling> findByDossierReference(String ref);
    List<InsuranceRegulatoryFiling> findByOperationalStatus(String status);
}
