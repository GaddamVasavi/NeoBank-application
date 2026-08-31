package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanCollateralValuationRepository extends JpaRepository<LoanCollateralValuation, UUID> {
    List<LoanCollateralValuation> findByUserId(UUID userId);
    Optional<LoanCollateralValuation> findByRecordKey(String recordKey);
    List<LoanCollateralValuation> findByStatus(String status);
}
