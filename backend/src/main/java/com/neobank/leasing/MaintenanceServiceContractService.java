package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface MaintenanceServiceContractService {
    List<MaintenanceServiceContractDto> getByUser(UUID userId);
    MaintenanceServiceContractDto create(MaintenanceServiceContractDto dto);
    MaintenanceServiceContractDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<MaintenanceServiceContractDto> listAll();
}
