package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface VehicleFleetLeaseScheduleRepository extends JpaRepository<VehicleFleetLeaseSchedule, UUID> {
    List<VehicleFleetLeaseSchedule> findByUserId(UUID userId);
    Optional<VehicleFleetLeaseSchedule> findByDossierReference(String ref);
    List<VehicleFleetLeaseSchedule> findByOperationalStatus(String status);
}
