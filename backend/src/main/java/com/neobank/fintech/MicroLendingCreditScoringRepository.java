package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MicroLendingCreditScoringRepository extends JpaRepository<MicroLendingCreditScoring, UUID> {
    List<MicroLendingCreditScoring> findByUserId(UUID userId);
    Optional<MicroLendingCreditScoring> findByInstitutionalRef(String ref);
    List<MicroLendingCreditScoring> findByExecutionStatus(String status);
}
