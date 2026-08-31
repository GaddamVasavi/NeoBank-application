package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BuyerCreditLimitAllocationRepository extends JpaRepository<BuyerCreditLimitAllocation, UUID> {
    List<BuyerCreditLimitAllocation> findByUserId(UUID userId);
    Optional<BuyerCreditLimitAllocation> findByDossierReference(String ref);
    List<BuyerCreditLimitAllocation> findByOperationalStatus(String status);
}
