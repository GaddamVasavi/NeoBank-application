package com.neobank.analyticsengine;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EconomicCapitalAllocationRepository extends JpaRepository<EconomicCapitalAllocation, UUID> {
    List<EconomicCapitalAllocation> findByUserId(UUID userId);
    Optional<EconomicCapitalAllocation> findByCoreReference(String ref);
    List<EconomicCapitalAllocation> findByProcessingStatus(String status);
}
