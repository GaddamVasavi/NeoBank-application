package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DebtorCreditAssessmentLogRepository extends JpaRepository<DebtorCreditAssessmentLog, UUID> {
    List<DebtorCreditAssessmentLog> findByUserId(UUID userId);
    Optional<DebtorCreditAssessmentLog> findByDossierReference(String ref);
    List<DebtorCreditAssessmentLog> findByOperationalStatus(String status);
}
