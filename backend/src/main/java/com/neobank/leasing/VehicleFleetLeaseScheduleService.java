package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface VehicleFleetLeaseScheduleService {
    List<VehicleFleetLeaseScheduleDto> getByUser(UUID userId);
    VehicleFleetLeaseScheduleDto create(VehicleFleetLeaseScheduleDto dto);
    VehicleFleetLeaseScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<VehicleFleetLeaseScheduleDto> listAll();
}
