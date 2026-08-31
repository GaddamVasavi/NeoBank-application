package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TransactionVelocityMetricRepository extends JpaRepository<TransactionVelocityMetric, UUID> {
    List<TransactionVelocityMetric> findByUserId(UUID userId);
    Optional<TransactionVelocityMetric> findByRecordKey(String recordKey);
    List<TransactionVelocityMetric> findByStatus(String status);
}
