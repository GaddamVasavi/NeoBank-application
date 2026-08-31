package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateExpenseClaimRepository extends JpaRepository<CorporateExpenseClaim, UUID> {
    List<CorporateExpenseClaim> findByUserId(UUID userId);
    Optional<CorporateExpenseClaim> findByTrackingCode(String code);
    List<CorporateExpenseClaim> findByStateFlag(String stateFlag);
}
