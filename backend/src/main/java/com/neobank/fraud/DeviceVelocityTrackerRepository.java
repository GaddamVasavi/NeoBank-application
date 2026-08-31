package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DeviceVelocityTrackerRepository extends JpaRepository<DeviceVelocityTracker, UUID> {
    List<DeviceVelocityTracker> findByUserId(UUID userId);
    Optional<DeviceVelocityTracker> findByCodeReference(String ref);
    List<DeviceVelocityTracker> findByStatus(String status);
}
