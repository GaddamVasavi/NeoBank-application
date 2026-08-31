package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ChannelUsageMetricRepository extends JpaRepository<ChannelUsageMetric, UUID> {
    List<ChannelUsageMetric> findByUserId(UUID userId);
    Optional<ChannelUsageMetric> findByRecordKey(String recordKey);
    List<ChannelUsageMetric> findByStatus(String status);
}
