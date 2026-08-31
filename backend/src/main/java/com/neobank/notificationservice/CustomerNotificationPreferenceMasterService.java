package com.neobank.notificationservice;
import java.util.List; import java.util.UUID;
public interface CustomerNotificationPreferenceMasterService {
    List<CustomerNotificationPreferenceMasterDto> getByUser(UUID userId);
    CustomerNotificationPreferenceMasterDto create(CustomerNotificationPreferenceMasterDto dto);
    CustomerNotificationPreferenceMasterDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CustomerNotificationPreferenceMasterDto> listAll();
}
