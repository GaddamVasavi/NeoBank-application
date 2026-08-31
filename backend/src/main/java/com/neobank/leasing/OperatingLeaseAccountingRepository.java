package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface OperatingLeaseAccountingRepository extends JpaRepository<OperatingLeaseAccounting, UUID> {
    List<OperatingLeaseAccounting> findByUserId(UUID userId);
    Optional<OperatingLeaseAccounting> findByDossierReference(String ref);
    List<OperatingLeaseAccounting> findByOperationalStatus(String status);
}
