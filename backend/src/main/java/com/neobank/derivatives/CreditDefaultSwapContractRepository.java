package com.neobank.derivatives;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CreditDefaultSwapContractRepository extends JpaRepository<CreditDefaultSwapContract, UUID> {
    List<CreditDefaultSwapContract> findByUserId(UUID userId);
    Optional<CreditDefaultSwapContract> findByClearingKey(String key);
    List<CreditDefaultSwapContract> findByAuditStatus(String status);
}
