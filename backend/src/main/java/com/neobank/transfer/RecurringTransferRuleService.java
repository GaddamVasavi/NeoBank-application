package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface RecurringTransferRuleService {
    List<RecurringTransferRuleDto> getByAccount(UUID accountId);
    RecurringTransferRuleDto create(RecurringTransferRuleDto dto);
    RecurringTransferRuleDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
