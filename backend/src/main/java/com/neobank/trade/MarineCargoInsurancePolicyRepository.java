package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MarineCargoInsurancePolicyRepository extends JpaRepository<MarineCargoInsurancePolicy, UUID> {
    List<MarineCargoInsurancePolicy> findByUserId(UUID userId);
    Optional<MarineCargoInsurancePolicy> findBySettlementRef(String ref);
    List<MarineCargoInsurancePolicy> findByLifecycleStatus(String status);
}
