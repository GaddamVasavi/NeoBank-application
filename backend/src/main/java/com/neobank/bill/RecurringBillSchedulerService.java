package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface RecurringBillSchedulerService {
    List<RecurringBillSchedulerDto> getByUser(UUID userId);
    RecurringBillSchedulerDto create(RecurringBillSchedulerDto dto);
    RecurringBillSchedulerDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<RecurringBillSchedulerDto> listAll();
}
