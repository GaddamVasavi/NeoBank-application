package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CollateralEvaluationRepository extends JpaRepository<CollateralEvaluation, UUID> {
    List<CollateralEvaluation> findByUserId(UUID userId);
    Optional<CollateralEvaluation> findByCodeReference(String ref);
    List<CollateralEvaluation> findByStatus(String status);
}
