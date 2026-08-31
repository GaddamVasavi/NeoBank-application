package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CovenantComplianceAuditRepository extends JpaRepository<CovenantComplianceAudit, UUID> {
    List<CovenantComplianceAudit> findByUserId(UUID userId);
    Optional<CovenantComplianceAudit> findByProtocolReference(String ref);
    List<CovenantComplianceAudit> findByOperationalState(String state);
}
