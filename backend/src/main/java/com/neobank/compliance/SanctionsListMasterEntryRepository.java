package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SanctionsListMasterEntryRepository extends JpaRepository<SanctionsListMasterEntry, UUID> {
    List<SanctionsListMasterEntry> findByUserId(UUID userId);
    Optional<SanctionsListMasterEntry> findByIdentifierCode(String code);
    List<SanctionsListMasterEntry> findByStatus(String status);
}
