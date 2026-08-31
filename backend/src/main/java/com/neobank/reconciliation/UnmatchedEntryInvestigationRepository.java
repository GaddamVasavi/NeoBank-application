package com.neobank.reconciliation;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface UnmatchedEntryInvestigationRepository extends JpaRepository<UnmatchedEntryInvestigation, UUID> {
    List<UnmatchedEntryInvestigation> findByUserId(UUID userId);
    Optional<UnmatchedEntryInvestigation> findByCoreReference(String ref);
    List<UnmatchedEntryInvestigation> findByProcessingStatus(String status);
}
