package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateGovernanceCharterRepository extends JpaRepository<CorporateGovernanceCharter, UUID> {
    List<CorporateGovernanceCharter> findByUserId(UUID userId);
    Optional<CorporateGovernanceCharter> findByInstitutionalRef(String ref);
    List<CorporateGovernanceCharter> findByExecutionStatus(String status);
}
