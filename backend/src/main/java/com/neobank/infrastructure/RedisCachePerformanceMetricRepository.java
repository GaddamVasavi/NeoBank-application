package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RedisCachePerformanceMetricRepository extends JpaRepository<RedisCachePerformanceMetric, UUID> {
    List<RedisCachePerformanceMetric> findByUserId(UUID userId);
    Optional<RedisCachePerformanceMetric> findByDossierReference(String ref);
    List<RedisCachePerformanceMetric> findByOperationalStatus(String status);
}
