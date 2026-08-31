package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PositionLimitMonitoringLogRepository extends JpaRepository<PositionLimitMonitoringLog, UUID> {
    List<PositionLimitMonitoringLog> findByUserId(UUID userId);
    Optional<PositionLimitMonitoringLog> findByInstitutionalRef(String ref);
    List<PositionLimitMonitoringLog> findByExecutionStatus(String status);
}
