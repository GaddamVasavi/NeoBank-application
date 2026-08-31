package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanPortfolioHealthRepository extends JpaRepository<LoanPortfolioHealth, UUID> {
    List<LoanPortfolioHealth> findByUserId(UUID userId);
    Optional<LoanPortfolioHealth> findByRecordKey(String recordKey);
    List<LoanPortfolioHealth> findByStatus(String status);
}
