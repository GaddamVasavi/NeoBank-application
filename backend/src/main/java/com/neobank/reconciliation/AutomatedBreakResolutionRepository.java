package com.neobank.reconciliation;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AutomatedBreakResolutionRepository extends JpaRepository<AutomatedBreakResolution, UUID> {
    List<AutomatedBreakResolution> findByUserId(UUID userId);
    Optional<AutomatedBreakResolution> findByCoreReference(String ref);
    List<AutomatedBreakResolution> findByProcessingStatus(String status);
}
