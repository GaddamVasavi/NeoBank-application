package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SmartContractEscrowDepositRepository extends JpaRepository<SmartContractEscrowDeposit, UUID> {
    List<SmartContractEscrowDeposit> findByUserId(UUID userId);
    Optional<SmartContractEscrowDeposit> findByInstitutionalRef(String ref);
    List<SmartContractEscrowDeposit> findByExecutionStatus(String status);
}
