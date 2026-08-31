package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TicketResolutionMetricRepository extends JpaRepository<TicketResolutionMetric, UUID> {
    List<TicketResolutionMetric> findByUserId(UUID userId);
    Optional<TicketResolutionMetric> findByRecordKey(String recordKey);
    List<TicketResolutionMetric> findByStatus(String status);
}
