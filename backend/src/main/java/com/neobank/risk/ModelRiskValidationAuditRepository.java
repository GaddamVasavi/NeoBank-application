package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ModelRiskValidationAuditRepository extends JpaRepository<ModelRiskValidationAudit, UUID> {
    List<ModelRiskValidationAudit> findByUserId(UUID userId);
    Optional<ModelRiskValidationAudit> findByTrackingCode(String code);
    List<ModelRiskValidationAudit> findByStateFlag(String stateFlag);
}
