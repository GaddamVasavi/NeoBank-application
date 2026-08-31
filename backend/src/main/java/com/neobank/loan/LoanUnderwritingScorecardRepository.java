package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanUnderwritingScorecardRepository extends JpaRepository<LoanUnderwritingScorecard, UUID> {
    List<LoanUnderwritingScorecard> findByUserId(UUID userId);
    Optional<LoanUnderwritingScorecard> findByCodeReference(String ref);
    List<LoanUnderwritingScorecard> findByStatus(String status);
}
