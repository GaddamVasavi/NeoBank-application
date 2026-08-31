package com.neobank.notificationservice;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CustomerNotificationPreferenceMasterRepository extends JpaRepository<CustomerNotificationPreferenceMaster, UUID> {
    List<CustomerNotificationPreferenceMaster> findByUserId(UUID userId);
    Optional<CustomerNotificationPreferenceMaster> findByRegistryKey(String key);
    List<CustomerNotificationPreferenceMaster> findByDeliveryStatus(String status);
}
