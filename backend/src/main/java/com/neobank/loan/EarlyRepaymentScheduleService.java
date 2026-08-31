package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface EarlyRepaymentScheduleService {
    List<EarlyRepaymentScheduleDto> getByUser(UUID userId);
    EarlyRepaymentScheduleDto create(EarlyRepaymentScheduleDto dto);
    EarlyRepaymentScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
