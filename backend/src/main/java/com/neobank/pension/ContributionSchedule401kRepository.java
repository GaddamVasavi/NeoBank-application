package com.neobank.pension;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ContributionSchedule401kRepository extends JpaRepository<ContributionSchedule401k, UUID> {
    List<ContributionSchedule401k> findByUserId(UUID userId);
    Optional<ContributionSchedule401k> findBySettlementRef(String ref);
    List<ContributionSchedule401k> findByLifecycleStatus(String status);
}
