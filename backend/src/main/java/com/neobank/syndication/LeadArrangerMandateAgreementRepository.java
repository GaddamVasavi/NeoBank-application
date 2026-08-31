package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LeadArrangerMandateAgreementRepository extends JpaRepository<LeadArrangerMandateAgreement, UUID> {
    List<LeadArrangerMandateAgreement> findByUserId(UUID userId);
    Optional<LeadArrangerMandateAgreement> findByDossierReference(String ref);
    List<LeadArrangerMandateAgreement> findByOperationalStatus(String status);
}
