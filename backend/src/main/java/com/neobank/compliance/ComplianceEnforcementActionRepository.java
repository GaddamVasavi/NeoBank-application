package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ComplianceEnforcementActionRepository extends JpaRepository<ComplianceEnforcementAction, UUID> {
    List<ComplianceEnforcementAction> findByUserId(UUID userId);
    Optional<ComplianceEnforcementAction> findByIdentifierCode(String code);
    List<ComplianceEnforcementAction> findByStatus(String status);
}
