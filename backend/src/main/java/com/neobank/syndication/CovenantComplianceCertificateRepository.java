package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CovenantComplianceCertificateRepository extends JpaRepository<CovenantComplianceCertificate, UUID> {
    List<CovenantComplianceCertificate> findByUserId(UUID userId);
    Optional<CovenantComplianceCertificate> findByDossierReference(String ref);
    List<CovenantComplianceCertificate> findByOperationalStatus(String status);
}
