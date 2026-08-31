package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ShareholderProposalRecordRepository extends JpaRepository<ShareholderProposalRecord, UUID> {
    List<ShareholderProposalRecord> findByUserId(UUID userId);
    Optional<ShareholderProposalRecord> findByInstitutionalRef(String ref);
    List<ShareholderProposalRecord> findByExecutionStatus(String status);
}
