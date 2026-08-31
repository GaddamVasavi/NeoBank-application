package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ClusterNodeHealthTelemetryRepository extends JpaRepository<ClusterNodeHealthTelemetry, UUID> {
    List<ClusterNodeHealthTelemetry> findByUserId(UUID userId);
    Optional<ClusterNodeHealthTelemetry> findByDossierReference(String ref);
    List<ClusterNodeHealthTelemetry> findByOperationalStatus(String status);
}
