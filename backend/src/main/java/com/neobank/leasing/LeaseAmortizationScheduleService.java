package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface LeaseAmortizationScheduleService {
    List<LeaseAmortizationScheduleDto> getByUser(UUID userId);
    LeaseAmortizationScheduleDto create(LeaseAmortizationScheduleDto dto);
    LeaseAmortizationScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LeaseAmortizationScheduleDto> listAll();
}
