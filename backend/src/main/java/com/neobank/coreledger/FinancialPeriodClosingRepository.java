package com.neobank.coreledger;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FinancialPeriodClosingRepository extends JpaRepository<FinancialPeriodClosing, UUID> {
    List<FinancialPeriodClosing> findByUserId(UUID userId);
    Optional<FinancialPeriodClosing> findByCoreReference(String ref);
    List<FinancialPeriodClosing> findByProcessingStatus(String status);
}
