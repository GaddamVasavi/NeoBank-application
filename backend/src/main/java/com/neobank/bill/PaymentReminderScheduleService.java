package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface PaymentReminderScheduleService {
    List<PaymentReminderScheduleDto> getByUser(UUID userId);
    PaymentReminderScheduleDto create(PaymentReminderScheduleDto dto);
    PaymentReminderScheduleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<PaymentReminderScheduleDto> listAll();
}
