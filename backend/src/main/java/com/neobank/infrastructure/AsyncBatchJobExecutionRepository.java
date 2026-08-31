package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AsyncBatchJobExecutionRepository extends JpaRepository<AsyncBatchJobExecution, UUID> {
    List<AsyncBatchJobExecution> findByUserId(UUID userId);
    Optional<AsyncBatchJobExecution> findByDossierReference(String ref);
    List<AsyncBatchJobExecution> findByOperationalStatus(String status);
}
