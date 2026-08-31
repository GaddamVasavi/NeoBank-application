package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AnnualGeneralMeetingDossierRepository extends JpaRepository<AnnualGeneralMeetingDossier, UUID> {
    List<AnnualGeneralMeetingDossier> findByUserId(UUID userId);
    Optional<AnnualGeneralMeetingDossier> findByInstitutionalRef(String ref);
    List<AnnualGeneralMeetingDossier> findByExecutionStatus(String status);
}
