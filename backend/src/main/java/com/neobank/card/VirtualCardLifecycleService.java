package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface VirtualCardLifecycleService {
    List<VirtualCardLifecycleDto> getByUser(UUID userId);
    VirtualCardLifecycleDto create(VirtualCardLifecycleDto dto);
    VirtualCardLifecycleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<VirtualCardLifecycleDto> listAll();
}
