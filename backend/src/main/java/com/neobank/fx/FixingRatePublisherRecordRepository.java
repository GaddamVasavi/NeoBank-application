package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FixingRatePublisherRecordRepository extends JpaRepository<FixingRatePublisherRecord, UUID> {
    List<FixingRatePublisherRecord> findByUserId(UUID userId);
    Optional<FixingRatePublisherRecord> findBySettlementRef(String ref);
    List<FixingRatePublisherRecord> findByLifecycleStatus(String status);
}
