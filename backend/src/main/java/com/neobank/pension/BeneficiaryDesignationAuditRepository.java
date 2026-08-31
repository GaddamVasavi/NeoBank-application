package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BeneficiaryDesignationAuditRepository extends JpaRepository<BeneficiaryDesignationAudit, UUID> {
    List<BeneficiaryDesignationAudit> findByUserId(UUID userId);
    Optional<BeneficiaryDesignationAudit> findBySettlementRef(String ref);
    List<BeneficiaryDesignationAudit> findByLifecycleStatus(String status);
}
