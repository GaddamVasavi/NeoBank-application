package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface MaintenanceWindowScheduleService {
    List<MaintenanceWindowScheduleDto> getByUser(UUID userId);
    MaintenanceWindowScheduleDto create(MaintenanceWindowScheduleDto dto);
    MaintenanceWindowScheduleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<MaintenanceWindowScheduleDto> listAll();
}
