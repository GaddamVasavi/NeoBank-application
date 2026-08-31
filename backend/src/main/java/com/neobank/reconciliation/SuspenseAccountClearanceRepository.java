package com.neobank.reconciliation;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SuspenseAccountClearanceRepository extends JpaRepository<SuspenseAccountClearance, UUID> {
    List<SuspenseAccountClearance> findByUserId(UUID userId);
    Optional<SuspenseAccountClearance> findByCoreReference(String ref);
    List<SuspenseAccountClearance> findByProcessingStatus(String status);
}
