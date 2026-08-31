package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SystemHealthTelemetryRepository extends JpaRepository<SystemHealthTelemetry, UUID> {
    List<SystemHealthTelemetry> findByUserId(UUID userId);
    Optional<SystemHealthTelemetry> findByRecordKey(String recordKey);
    List<SystemHealthTelemetry> findByStatus(String status);
}
