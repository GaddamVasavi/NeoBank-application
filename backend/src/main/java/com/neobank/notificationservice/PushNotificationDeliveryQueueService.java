package com.neobank.notificationservice;
import java.util.List; import java.util.UUID;
public interface PushNotificationDeliveryQueueService {
    List<PushNotificationDeliveryQueueDto> getByUser(UUID userId);
    PushNotificationDeliveryQueueDto create(PushNotificationDeliveryQueueDto dto);
    PushNotificationDeliveryQueueDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<PushNotificationDeliveryQueueDto> listAll();
}
