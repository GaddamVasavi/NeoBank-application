package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WhistleblowerInvestigationFileRepository extends JpaRepository<WhistleblowerInvestigationFile, UUID> {
    List<WhistleblowerInvestigationFile> findByUserId(UUID userId);
    Optional<WhistleblowerInvestigationFile> findByInstitutionalRef(String ref);
    List<WhistleblowerInvestigationFile> findByExecutionStatus(String status);
}
