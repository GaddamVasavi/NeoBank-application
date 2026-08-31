package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TaxDeferredGrowthScheduleRepository extends JpaRepository<TaxDeferredGrowthSchedule, UUID> {
    List<TaxDeferredGrowthSchedule> findByUserId(UUID userId);
    Optional<TaxDeferredGrowthSchedule> findBySettlementRef(String ref);
    List<TaxDeferredGrowthSchedule> findByLifecycleStatus(String status);
}
