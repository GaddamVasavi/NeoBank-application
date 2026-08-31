package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PensionAnnuityDisbursementRepository extends JpaRepository<PensionAnnuityDisbursement, UUID> {
    List<PensionAnnuityDisbursement> findByUserId(UUID userId);
    Optional<PensionAnnuityDisbursement> findBySettlementRef(String ref);
    List<PensionAnnuityDisbursement> findByLifecycleStatus(String status);
}
