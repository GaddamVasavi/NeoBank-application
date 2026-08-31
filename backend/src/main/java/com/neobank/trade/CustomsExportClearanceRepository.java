package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CustomsExportClearanceRepository extends JpaRepository<CustomsExportClearance, UUID> {
    List<CustomsExportClearance> findByUserId(UUID userId);
    Optional<CustomsExportClearance> findBySettlementRef(String ref);
    List<CustomsExportClearance> findByLifecycleStatus(String status);
}
