package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LifeInsurancePolicyWrapperRepository extends JpaRepository<LifeInsurancePolicyWrapper, UUID> {
    List<LifeInsurancePolicyWrapper> findByUserId(UUID userId);
    Optional<LifeInsurancePolicyWrapper> findBySettlementRef(String ref);
    List<LifeInsurancePolicyWrapper> findByLifecycleStatus(String status);
}
