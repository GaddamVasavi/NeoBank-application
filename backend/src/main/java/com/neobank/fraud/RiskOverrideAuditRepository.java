package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RiskOverrideAuditRepository extends JpaRepository<RiskOverrideAudit, UUID> {
    List<RiskOverrideAudit> findByUserId(UUID userId);
    Optional<RiskOverrideAudit> findByRecordKey(String recordKey);
    List<RiskOverrideAudit> findByStatus(String status);
}
