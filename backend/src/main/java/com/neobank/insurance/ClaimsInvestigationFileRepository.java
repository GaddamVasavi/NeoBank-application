package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ClaimsInvestigationFileRepository extends JpaRepository<ClaimsInvestigationFile, UUID> {
    List<ClaimsInvestigationFile> findByUserId(UUID userId);
    Optional<ClaimsInvestigationFile> findByDossierReference(String ref);
    List<ClaimsInvestigationFile> findByOperationalStatus(String status);
}
