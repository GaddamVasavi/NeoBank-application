package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BranchVaultBalanceLogRepository extends JpaRepository<BranchVaultBalanceLog, UUID> {
    List<BranchVaultBalanceLog> findByUserId(UUID userId);
    Optional<BranchVaultBalanceLog> findByTrackingCode(String code);
    List<BranchVaultBalanceLog> findByStateFlag(String stateFlag);
}
