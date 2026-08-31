package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BenchmarkComparisonMetricRepository extends JpaRepository<BenchmarkComparisonMetric, UUID> {
    List<BenchmarkComparisonMetric> findByUserId(UUID userId);
    Optional<BenchmarkComparisonMetric> findByIdentifierCode(String code);
    List<BenchmarkComparisonMetric> findByStatus(String status);
}
