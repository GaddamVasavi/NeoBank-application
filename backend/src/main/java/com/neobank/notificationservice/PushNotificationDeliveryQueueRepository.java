package com.neobank.notificationservice;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PushNotificationDeliveryQueueRepository extends JpaRepository<PushNotificationDeliveryQueue, UUID> {
    List<PushNotificationDeliveryQueue> findByUserId(UUID userId);
    Optional<PushNotificationDeliveryQueue> findByRegistryKey(String key);
    List<PushNotificationDeliveryQueue> findByDeliveryStatus(String status);
}
