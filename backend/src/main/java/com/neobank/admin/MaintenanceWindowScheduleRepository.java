package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MaintenanceWindowScheduleRepository extends JpaRepository<MaintenanceWindowSchedule, UUID> {
    List<MaintenanceWindowSchedule> findByUserId(UUID userId);
    Optional<MaintenanceWindowSchedule> findByRecordKey(String recordKey);
    List<MaintenanceWindowSchedule> findByStatus(String status);
}
