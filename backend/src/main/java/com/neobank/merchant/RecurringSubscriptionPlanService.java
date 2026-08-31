package com.neobank.merchant;
import java.util.List; import java.util.UUID;
public interface RecurringSubscriptionPlanService {
    List<RecurringSubscriptionPlanDto> getByUser(UUID userId);
    RecurringSubscriptionPlanDto create(RecurringSubscriptionPlanDto dto);
    RecurringSubscriptionPlanDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RecurringSubscriptionPlanDto> listAll();
}
