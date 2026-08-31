package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ComplianceOfficerNoteRepository extends JpaRepository<ComplianceOfficerNote, UUID> {
    List<ComplianceOfficerNote> findByUserId(UUID userId);
    Optional<ComplianceOfficerNote> findByRecordKey(String recordKey);
    List<ComplianceOfficerNote> findByStatus(String status);
}
