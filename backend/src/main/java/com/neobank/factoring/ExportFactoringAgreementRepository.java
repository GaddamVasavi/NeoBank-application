package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ExportFactoringAgreementRepository extends JpaRepository<ExportFactoringAgreement, UUID> {
    List<ExportFactoringAgreement> findByUserId(UUID userId);
    Optional<ExportFactoringAgreement> findByDossierReference(String ref);
    List<ExportFactoringAgreement> findByOperationalStatus(String status);
}
