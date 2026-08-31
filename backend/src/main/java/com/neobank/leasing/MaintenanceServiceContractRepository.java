package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MaintenanceServiceContractRepository extends JpaRepository<MaintenanceServiceContract, UUID> {
    List<MaintenanceServiceContract> findByUserId(UUID userId);
    Optional<MaintenanceServiceContract> findByDossierReference(String ref);
    List<MaintenanceServiceContract> findByOperationalStatus(String status);
}
