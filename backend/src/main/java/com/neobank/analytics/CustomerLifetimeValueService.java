package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface CustomerLifetimeValueService {
    List<CustomerLifetimeValueDto> getByUser(UUID userId);
    CustomerLifetimeValueDto create(CustomerLifetimeValueDto dto);
    CustomerLifetimeValueDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CustomerLifetimeValueDto> listAll();
}
