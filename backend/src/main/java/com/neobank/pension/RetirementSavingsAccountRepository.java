package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RetirementSavingsAccountRepository extends JpaRepository<RetirementSavingsAccount, UUID> {
    List<RetirementSavingsAccount> findByUserId(UUID userId);
    Optional<RetirementSavingsAccount> findBySettlementRef(String ref);
    List<RetirementSavingsAccount> findByLifecycleStatus(String status);
}
